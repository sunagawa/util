package definition


object Countries {

  case object Asia extends World {

    case object Japan extends Asia

    case object China extends Asia

  }

}

sealed abstract class World() {}

sealed abstract class Asia() {}
