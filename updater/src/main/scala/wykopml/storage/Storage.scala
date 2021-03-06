package wykopml.storage

import com.websudos.phantom.dsl._

import scala.concurrent.Await
import scala.concurrent.duration._

class WykopDatabase(val keyspace: KeySpaceDef) extends com.websudos.phantom.db.DatabaseImpl(keyspace) {

  case object wykops extends Wykops with keyspace.Connector

  case object votes extends Votes with keyspace.Connector

  case object comments extends Comments with keyspace.Connector

}

object WykopDatabase extends WykopDatabase(Defaults.connector) {

  def init() = Await.result(autocreate().future(), Duration.Inf)

}

