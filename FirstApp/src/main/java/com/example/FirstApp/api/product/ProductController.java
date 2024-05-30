package com.example.FirstApp.api.product;


import com.example.FirstApp.api.product.dto.ProductDtoAdauga;
import com.example.FirstApp.api.product.dto.ProductDtoModifica;
import com.example.FirstApp.domain.product.Product;
import com.example.FirstApp.domain.product.ProductRepository;
import com.example.FirstApp.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
//        return productRepository.findAllProducts();
    }

    @GetMapping("/products/{id}")
    Product getById(@PathVariable Integer id) {
        return productRepository.findById(id).get();
    }

//    @PostMapping("/adauga")
//    Product adauga(@RequestBody ProductDtoAdauga command) {
//
//        Product productToBesaved = new Product();
//        productToBesaved.setName(command.getName());
//        productToBesaved.setPriceWithoutTVA(command.getPriceWithoutTVA());
//        productToBesaved.setPriceWithTVA(command.getPriceWithTVA());
//        productToBesaved.setTVA(command.getTva());
//
//        return productRepository.save(productToBesaved);
//    }


    @PostMapping("/adauga")
    Product adauga(@RequestBody ProductDtoAdauga commandDto) {

        Product productToBeSaved = new Product();

        if (commandDto.getName() == null || commandDto.getName() == " ") {
            throw new BadRequestException("Trebuie completat un nume pentru produs!");
        }

        productToBeSaved.setName(commandDto.getName());
        productToBeSaved.setPriceWithoutTVA(commandDto.getPriceWithoutTVA());
        productToBeSaved.setTVA(commandDto.getTva());
        productToBeSaved.setPriceWithTVA(commandDto.getPriceWithTVA());

        return productRepository.save(productToBeSaved);
    }

    /**
     * Update
     */
    @PostMapping("/modifica/{id}")
    Product modifica(
            @PathVariable Integer id,
            @RequestBody ProductDtoModifica modificaDto
    ) {

        Product productToBeModified = productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Nu exista produsul cu id-ul:" + id));

        /** verificare calcule price/tva */
        if (modificaDto.getPriceWithoutTVA() + modificaDto.getTva() != modificaDto.getPriceWithTVA()) {
            throw new BadRequestException("Pretul fara tva+tva nu corespunde nu pretul cu tva!");
        }

        productToBeModified.setName(modificaDto.getName());
        productToBeModified.setPriceWithoutTVA(modificaDto.getPriceWithoutTVA());
        productToBeModified.setTVA(modificaDto.getTva());
        productToBeModified.setPriceWithTVA(modificaDto.getPriceWithTVA());

        return productRepository.save(productToBeModified);

    }

    /**
     * Discount utilizator->cupon pt produs/cupon pt tot cosul
     */
    @PostMapping("/checkout/discount/{id}")
    Product discount(@PathVariable Integer id,
                     @RequestParam String discount) {

        Product productDiscount = productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Nu exista produsul cu id-ul:" + id));

        double procentDiscount = 0;
        if (discount == null || !discount.equals("java")) {
            procentDiscount = 1;
        } else {
            procentDiscount = (double) 50 / 100;
        }

        int priceWithoutTva = (int) (productDiscount.getPriceWithoutTVA() * procentDiscount);
        int tva = (int) (productDiscount.getTVA() * procentDiscount);
        int priceWithTva = (int) (productDiscount.getPriceWithTVA() * procentDiscount);

        productDiscount.setPriceWithoutTVA(priceWithoutTva);
        productDiscount.setTVA(tva);
        productDiscount.setPriceWithTVA(priceWithTva);

        return productDiscount;

    }


    /**
     * Delete
     */
    @DeleteMapping("/sterge/{id}")
    ResponseEntity<String> sterge(@PathVariable Integer id) {

        Product productToBeDeleted = productRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Nu exista produsul cu id-ul:" + id));

        productRepository.delete(productToBeDeleted);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Produsul a fost sters!");

    }

    @GetMapping("/test")
    public String productTest() {
        return "<h1>test1234</h1>";
    }

    @GetMapping
    public String productString() {
        return "product String";
    }

}
