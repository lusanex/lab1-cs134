package com.zybooks.pizzaparty

import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8
/**
 *    A class that calculates the number of pizzas needed for a pizza party based on the
 *    party size and hunger level.
 *    @param partySize The number of people at the party.
 *    @param hungerLevel The hunger level of the party guests,
 *    which determines the number of pizza slices per person.
 *
**/
class PizzaCalculator(partySize: Int, var hungerLevel: HungerLevel) {
   var partySize = 0
      set(value) {
         field = if (value >= 0) value else 0
      }

   enum class HungerLevel(var numSlices: Int) {
      LIGHT(2), MEDIUM(3), RAVENOUS(4)
   }

   val totalPizzas: Int
      get() {
         return ceil(partySize * hungerLevel.numSlices / SLICES_PER_PIZZA.toDouble()).toInt()
      }

   init {
      this.partySize = partySize
   }
}