package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._


object ManagersController extends Controller {

  def getSalesPerProduct = Action {
      Ok(views.html.managers.sales())
  }

  def getSalesPerCategory = Action {
      Ok(views.html.managers.sales())
  }

  def getSalesPerCustomer = Action {
      Ok(views.html.managers.sales())
  }

  def updateCustomerStatus = Action {
      Ok(views.html.managers.sales())
  }

  def setItemPrice = Action {
      Ok(views.html.managers.sales())
  }
}
