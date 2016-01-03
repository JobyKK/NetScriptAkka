package worker.store

import akka.actor.Actor

import scala.concurrent.forkjoin.ThreadLocalRandom

class StoreWorkExecutor extends Actor {

  def rnd = ThreadLocalRandom.current

  def receive = {
    case n: Int =>
      val n2 = n * n / rnd.nextInt(0, 10)
      val result = s"$n * $n = $n2"
      sender() ! StoreWorker.WorkComplete(result)
  }

}