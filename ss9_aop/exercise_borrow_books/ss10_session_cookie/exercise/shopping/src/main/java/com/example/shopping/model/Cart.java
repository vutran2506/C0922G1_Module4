package com.example.shopping.model;


import java.util.HashMap;
import java.util.Map;


public class Cart {
    private Map<Product,Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product,Integer>entry: products.entrySet()){
            if (entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product,Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer>entry: products.entrySet()){
            if (entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void  addProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        }else {
            Map.Entry<Product,Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() +1;
            products.replace(itemEntry.getKey(),newQuantity);

        }
    }

    public void  deleteProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        }else {
            Map.Entry<Product,Integer> itemEntry = selectItemInCart(product);

          products.remove(itemEntry.getKey());

        }
    }

    public void deleteAll(){
        products.clear();
    }

    public void downValue(Product product) {
        Map.Entry<Product,Integer> entry = selectItemInCart(product);
        if (entry.getValue() == 1) {
            products.remove(entry.getKey());
        } else {
            Integer value = entry.getValue() - 1;
            products.replace(entry.getKey(),value);
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()){
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

     public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product,Integer> entry :products.entrySet()){
            payment += entry.getKey().getPrice() * entry.getValue();

        }
        return payment;
     }
}
