package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._
import models.Product
import play.api.data.format.Formats._

object ProductsController extends Controller {

  val productForm = Form(
    single(
      "price" -> of[Double]
    )
  )

  def list = Action {
    Ok(views.html.products.list(Product.all()))
  }

  def detail(id: Int) = Action {
    Ok(views.html.products.detail(Product.getById(id), productForm))
  }

  def manage(id: Int) = Action {
    Ok(views.html.products.manage(Product.getById(id), productForm))
  }

  def update = Action { implicit request =>
    productForm.bindFromRequest.fold(
      //error => BadRequest(views.html.products.detail(Product.getById(id), productForm)),
      error => BadRequest(views.html.products.list(Product.all())),
      {
        case (price) => {
          Product.update(price)
          //Redirect(routes.ProductsController.detail(Product.getById(id), productForm))
          Redirect(routes.ProductsController.list())
        }
      }
    )
  }


}
