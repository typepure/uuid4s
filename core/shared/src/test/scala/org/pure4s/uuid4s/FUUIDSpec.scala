package org.pure4s.uuid4s

import java.util.UUID

import cats.effect.IO
import org.scalatest._

class FUUIDSpec extends FunSpec with Matchers with FUUIDArbitrary {

  describe("FUUID[F[_]].fromString") {
    it(s"Fail when parsing an invalid string") {
      assertThrows[IllegalArgumentException] {
        FUUID[IO].fromString("invalid uuid").unsafeRunSync()
      }
    }
    it(s"Fail when parsing invalid uuid") {
      assertThrows[IllegalArgumentException] {
        FUUID[IO].fromString(inValidUUIDAsString).unsafeRunSync()
      }
    }
    it(s"Succeed when parsing a valid UUID") {
      val result = FUUID[IO].fromString(validUUIDAsString).unsafeRunSync()
      result.toString shouldBe validUUIDAsString
    }
  }
  describe("FUUID[F[_]].fromUUID") {
    it(s"Succeed when parsing a valid UUID") {
      val result = FUUID[IO].fromUUID(validJUUID).unsafeRunSync()
      result.toString() shouldBe validUUIDAsString
    }
  }
  describe("FUUID[F[_]].randomUUID") {
    it(s"Succeed when generating random valid UUID") {
      val uuidResult = FUUID[IO].random.unsafeRunSync()
      uuidResult shouldBe a[UUID]
    }
  }
  describe("FUUID[F[_]].toString") {
    it(s"Succeed when convert UUID to String") {
      val uuidResult: UUID = FUUID[IO].fromString(validUUIDAsString).unsafeRunSync()
      val uuidAsString: String = FUUID[IO].toString(uuidResult).unsafeRunSync()
      uuidAsString shouldBe validUUIDAsString
    }
  }
}
