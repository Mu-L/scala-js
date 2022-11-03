package build

import com.typesafe.tools.mima.core._
import com.typesafe.tools.mima.core.ProblemFilters._

object BinaryIncompatibilities {
  val IR = Seq(
  )

  val Linker = Seq(
  )

  val LinkerInterface = Seq(
    // private, not an issue
    ProblemFilters.exclude[DirectMissingMethodProblem]("org.scalajs.linker.interface.Semantics.this"),
  )

  val SbtPlugin = Seq(
  )

  val TestAdapter = Seq(
  )

  val Library = Seq(
    // new methods in sealed trait, not an issue
    ProblemFilters.exclude[ReversedMissingMethodProblem]("scala.scalajs.js.Dynamic.**"),
  )

  val TestInterface = Seq(
  )

  val JUnitRuntime = Seq(
  )
}
