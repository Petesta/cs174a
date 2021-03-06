package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.Category

object CategoryController extends Controller {
  val categoryForm = Form(
    "name" -> nonEmptyText
  )

  def list = Action {
    Ok(views.html.managers.categories(Category.all()))
  }
}
