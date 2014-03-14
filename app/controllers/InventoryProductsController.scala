package controllers

import play.api._
import play.api.libs.json._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.InventoryProduct

object InventoryProductsController extends Controller {
  val inventoryProductForm  = Form(
    "stockNumber" -> nonEmptyText
  )

  /*
  def check(stockNumber: String) = {
    val productQty = InventoryProduct.getQtyOfProduct(stockNumber)
  }
  */

 def productQty = Action { implicit request =>
   Ok(views.html.external.productqty())
 }

 def qty(amount: Int) = Action { implicit request =>
   Ok(views.html.external.qty(InventoryProduct.qtyOfProduct(amount)))
 }

 /*
 def quantityValue(stockNumber: String) = Action { implicit request =>
   val returnRequest = request.queryString.map { case (k,v) => k -> v.mkString }
   println(returnRequest)

   returnRequest.get("stockNumber") match {
     case Some(stockNumber) => {
       val num = InventoryProduct.qtyOfProduct(stockNumber)
       println(num)
       Ok(Json.toJson(num))
     }

     case None => NotFound
   }
 }

  def quantityOfProduct = Action { implicit request =>
    inventoryProductForm.bindFromRequest.fold(
      errors => NotFound,
      {
        num => Ok
          //val qty = InventoryProduct.getQtyOfProduct(num)
          //Ok(views.html.external.productQty(qty))
      }
    )
  }
  */
}
