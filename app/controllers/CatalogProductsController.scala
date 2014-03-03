package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.data.validation.Constraints._

import models.CatalogProduct

object CatalogProductsController extends Controller {
  val catalogProductForm = Form(
    "stockNumber" -> nonEmptyText
  )

  def newCatalogProduct = TODO
}
