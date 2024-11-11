package com.apex.eqp.inventory.controllers;

import com.apex.eqp.inventory.entities.RecalledProduct;
import com.apex.eqp.inventory.services.RecalledProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "api/inventory/recalled")
public class RecalledProductController {

    private final RecalledProductService recalledProductService;

    @PostMapping
    public ResponseEntity<RecalledProduct> createProduct(@RequestBody RecalledProduct recalledProduct) {
        return ResponseEntity.ok(recalledProductService.save(recalledProduct));
    }

    @GetMapping("/")
    ResponseEntity<Collection<RecalledProduct>> findRecallProducts() {
        Collection<RecalledProduct> allRecalledProducts = recalledProductService.getAllRecalledProducts();

        return ResponseEntity.ok(allRecalledProducts);
    }
    /*
    NEEDS CRUD!
     */
    // Update an existing recalled product by ID
    @PutMapping("/{id}")
    public ResponseEntity<RecalledProduct> updateRecalledProduct(@PathVariable Integer id, @RequestBody RecalledProduct productDetails) {
        Optional<RecalledProduct> optionalProduct = recalledProductService.findById(id);
        if (optionalProduct.isPresent()) {
            RecalledProduct existingProduct = optionalProduct.get();
            existingProduct.setName(productDetails.getName());
            existingProduct.setExpired(productDetails.getExpired());
            recalledProductService.save(existingProduct); // Save the updated recalled product
            return ResponseEntity.ok(existingProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a recalled product by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecalledProduct(@PathVariable Integer id) {
        if (recalledProductService.existsById(id)) {
            recalledProductService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
