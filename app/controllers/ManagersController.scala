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

  def updateCustomerStatus(customerID: Int) = Action { implicit request =>
    val purchases = Order.getTotalPurchase(customerID)
    var status = ""
    var total = new BigDecimal(0.0)

    purchases.foreach { p =>
      println("subtotal before: " + total)
      val qty = new BigDecimal(p._2.qty)
      val subtotal = (p._2.priceBuy).multiply(qty)
      println("subtotal: " + subtotal)
      println("qty " + qty +" * " + p._2.priceBuy)
      total = total.add(subtotal)
      println("subtotal after: " + total)
    }
    println("total :" + total)

    if(total.compareTo(new BigDecimal(500)) > 0){
      status = "Gold"
    } else if ((total.compareTo(new BigDecimal(100)) > 0) && (total.compareTo(new BigDecimal(500)) <= 0)) {
      status = "Silver"
    } else if ((total.compareTo(new BigDecimal(0)) > 0) && (total.compareTo(new BigDecimal(100)) <= 0)) {
      status = "Green"
    } else {
      status = "New"
    }

    Customer.updateStatus(customerID, status)
    Ok("Status updated")
  }


}
