package controllers

import java.time._

import play.api.Play._
import play.api.i18n.Messages.Implicits._
import play.api.i18n._

import scala.language.implicitConversions


object Implicits {
  implicit def localizedRequest2Messages(implicit request: LocalizedRequest): Messages = applicationMessages(Utils.getLang(request.lang), current)

  implicit def localizedMapWrapper(m: Map[String, String]): LocalizedMap = new LocalizedMap(m)

  implicit def localizedTimeWrapper(time: LocalDateTime): LocalizedDatetime = new LocalizedDatetime(time)
}
