package models

import anorm._
import anorm.SqlParser._

import java.util.{Date}

import play.api.db._
import play.api.Play.current

case class CartProduct(id: Int, qty: Int, catProductID: Int, cartID: Int)

object CartProduct {
  val cartProduct = {
    get[Int]("id") ~
    get[Int]("qty") ~
    get[Int]("catProductID") ~
    get[Int]("cartID") map {
      case id~qty~catProductID~cartID => CartProduct(id, qty, catProductID, cartID)
    }
  }

  def create {
    // TODO: We'll probably need to get FOREIGN KEY values for catProductID and cartID
    DB.withConnection { implicit c =>
      SQL("insert into cartProducts(qty, catProductID, cartID) values ({qty, catProductID, cartID})").on(
        'qty -> qty,
        'catProductID -> catProductID,
        'cartID -> cartID
      ).executeInsert()
    }
  }
}
