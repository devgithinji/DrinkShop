package com.example.drinkshop.Database.DataSource;

import com.example.drinkshop.Database.ModelDB.Cart;

import java.util.List;

import io.reactivex.Flowable;

public class CartRepository implements ICartDataSource {

    private ICartDataSource iCartDataSource;

    public CartRepository(ICartDataSource iCartDataSource) {
        this.iCartDataSource = iCartDataSource;
    }

    private static CartRepository instance;

    public static  CartRepository getInstance(ICartDataSource iCartDataSource)
    {
        if (instance == null)
            instance = new CartRepository(iCartDataSource);
        return  instance;
    }

    @Override
    public Flowable<List<Cart>> getCartItems() {
        return iCartDataSource.getCartItems();
    }

    @Override
    public Flowable<List<Cart>> getCartItemsById(int cartItemId) {
        return iCartDataSource.getCartItemsById(cartItemId);
    }

    @Override
    public int countCartItems() {
        return iCartDataSource.countCartItems();
    }

    @Override
    public void emptyCart() {
        iCartDataSource.emptyCart();
    }

    @Override
    public void insertToCart(Cart... carts) {
        iCartDataSource.insertToCart(carts);
    }

    @Override
    public void updatecart(Cart... carts) {
        iCartDataSource.updatecart(carts);
    }

    @Override
    public void deletecartItem(Cart cart) {
        iCartDataSource.deletecartItem(cart);
    }
}
