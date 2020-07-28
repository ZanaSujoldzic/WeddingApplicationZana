package wedding.screen.pagination;

import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import wedding.entity.Product;
import wedding.entity.facade.ProductFacadeLocal;

@Named
@SessionScoped
public class ProductPaginationManagedBean implements Serializable {

    @Inject
    private ProductFacadeLocal productFacadeLocal;

    private List<Product> products;
    private PaginationHelper pagination;
    private int selectedItemIndex;
    private DataModel dataModel = null;
    private Product item;
    private String name = "";
    private String code = "";

    public ProductPaginationManagedBean() {
    }

    public List<Product> getProducts() {
        if (products == null) {
            products = productFacadeLocal.findAll();
        }
        return products;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
    
    

    public PaginationHelper getPagination() {

        if (pagination == null) {
            pagination = new PaginationHelper(10) {
                @Override
                public int getItemsCount() {
                    return productFacadeLocal.count();
                }

                @Override
                public DataModel createPageDataModel() {
                    List<Product> productsInRange = productFacadeLocal.findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()});
                    return new ListDataModel(productsInRange);
                }
            };
        }
        return pagination;
    }

    public DataModel getDataModel() {
        if (dataModel == null) {
            dataModel = getPagination().createPageDataModel();
        }
        return dataModel;
    }

    private void recreateModel() {
        dataModel = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    private void updateCurrentItem() {
        int count = productFacadeLocal.count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            item = productFacadeLocal.findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "adminProducts_1";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "adminProducts_1";
    }
}
