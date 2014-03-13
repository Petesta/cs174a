package models

import anorm._
import anorm.SqlParser._

import java.util.{Date}

import play.api.db._
import play.api.Play.current
import play.mvc._

import models.Product

case class CartProduct(id: Int, qty: Int, productID: Int, cartID: Int)

object CartProduct {
  val cartProduct = {
    get[Int]("id") ~
    get[Int]("qty") ~
    get[Int]("productID") ~
    get[Int]("cartID") map {
      case id~qty~productID~cartID => CartProduct(id, qty, productID, cartID)
    }
  }

  def insertProduct(qty: Int, productID: Int, cartID: Int) {
    DB.withConnection { implicit c =>
      SQL("insert into cartProducts(qty, productID, cartID) values ({qty}, {productID}, {cartID})").on(
        'qty -> qty,
        'productID -> productID,
        'cartID -> cartID
      ).executeInsert()
    }
  }

  def deleteProduct(cartProductID: Int, cartID: Int) {
    DB.withConnection { implicit c =>
      SQL("delete from cartProducts where id = {cartProductID} and cartID = {cartID}").on(
        'cartProductID -> cartProductID,
        'cartID -> cartID
        ).executeUpdate
    }
  }
   def getAllByCart(cartID: Int): List[CartProduct] = DB.withConnection { implicit c =>
    SQL("select * from cartProducts where cartID = {cartID}").on(
      'cartID -> cartID).as(cartProduct *)
  }


  def listAllProducts(cartID: Int): List[(CartProduct, Product)] = DB.withConnection { implicit c =>
    SQL("select * from cartProducts cp inner join products p on cp.productID = p.id where cartID = {cartID}").on(
      'cartID -> cartID).as(CartProduct.cartProduct ~ Product.product map(flatten)*)
  }
}
