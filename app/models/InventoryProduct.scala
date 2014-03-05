package models

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class InventoryProduct(id: Int, stockNumber: String, companyID: Int, modelID: Int, replenishment: Int, qty: Int, minLvl: Int, location: String, maxLvl: Int)

object InventoryProduct {
  val inventoryProduct = {
    get[Int]("id") ~
    get[String]("stockNumber") ~
    get[Int]("companyID") ~
    get[Int]("modelID") ~
    get[Int]("replenishment") ~
    get[Int]("qty") ~
    get[Int]("minLvl") ~
    get[String]("location") ~
    get[Int]("maxLvl") map {
      case id~stockNumber~companyID~modelID~replenishment~qty~minLvl~location~maxLvl => InventoryProduct(id, stockNumber, companyID, modelID, replenishment, qty, minLvl, location, maxLvl)
    }
  }
}
