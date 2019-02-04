import java.util.UUID
import cats.effect.IO
import org.pure4s.uuid4s.FUUID

object BasicExampleMain extends App {

  // Parsing
  val uuid1: UUID =
    FUUID[IO].fromString("7cfb70a9-0764-4851-a28c-309393aea2eb").unsafeRunSync()

  // Generating
  val uuid2: UUID = FUUID[IO].random.unsafeRunSync()
}
