package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import models.OrdersProduct
import models.Order
import models.Product
import models.Customer
import java.math.{BigDecimal}


object ManagersController extends Controller {


  def getSalesPerProduct(productID: Int) = Action { implicit request =>
      val products = OrdersProduct.getMonthlySalesPerProduct(productID)
      println("products by id " + productID)
      println(products)
      Ok(views.html.managers.sales(products))
  }


  def getSalesPerCategory(catID: Int) = Action { implicit request =>
    Ok(views.html.managers.salesCategory(OrdersProduct.getMonthlySalesPerCategory(catID)))
  }

  def getSalesPerCustomer(customerID: Int) = Action { implicit request =>
    Ok(views.html.managers.salesCustomer(OrdersProduct.getMonthlySalesPerCustomer(customerID)))
  }

  def updateCustomerStatus = Action {
    val purchases = Order.getTotalPurchase(1)
    var status = ""
    var total = 0

    /* TODO: foreach?
    purchases.foreach { p =>
      println(p)
      total += p.qty * p.priceBuy
    }*/

    if(total > 500){
      status = "Gold"
    } else if (total > 100 && total <= 500) {
      status = "Silver"
    } else if (total > 0 && total <= 100) {
      status = "Green"
    } else {
      status = "NEW"
    }

    Customer.updateStatus(1, status)
    Ok("Status updated")
  }


}
