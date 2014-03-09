package models

import anorm._
import anorm.SqlParser._

import java.util.{Date}

import play.api.db._
import play.api.Play.current
import play.mvc._

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
    //val blah = ??? //Http.Request.current.cookies.get("id")
    //val cartID = 1
      SQL("insert into cartProducts(qty, productID, cartID) values ({qty}, {productID}, {cartID})").on(
        'qty -> qty,
        'productID -> productID,
        'cartID -> cartID
      ).executeInsert()
    }
  }
}
