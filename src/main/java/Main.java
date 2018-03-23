import model.beans.Cart;
import model.beans.Product;
import model.database.CartOperation;
import model2.doa.CartDao;
import model2.doa.CategoryDao;
import model2.entity.CartEntity;
import model2.entity.CategoryEntity;
import model2.entity.UserEntity;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        new CartOperation().finalizeCart(32);
    }
}
