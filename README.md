# FruitJackpot
A simple CLI Program to play jackpot similar to in casino, but instead of 777, now using fruits as the symbol. Created to remind myself how to use Java again. Utilizing OOP and design pattern as best as I could. 

Will be continued as a 1-2 hour series small programs

## Application Flow
```mermaid
flowchart TD
        A(Start) -->B[Init dependencies & Jackpot settings] 
        B --> C[Spin!]
        C --> D{Loop through all prize}
        D --> E[Check prize condition]
        E -- Yes --> F[Give prize to player]
        F --> D
        E -- No --> D
        D -- End --> H[Continue? y/n]
        H -- Yes --> C
        H -- No --> J(End)
```

## Class Diagram (not updated)
```mermaid
classDiagram

class SpinWheel {
    -slots: int
    -fruits : List<~Fruit~>
    -results : List<~Fruit~>
    -isSpinned : boolean
    -cost : int
}
SpinWheel : +getCost() int
SpinWheel : +spin() List<~Fruit~>
SpinWheel : +getResult() List<~Fruit~>
SpinWheel : +reset() void

class Fruit
<<enumeration>> Fruit
Fruit : GREEN
Fruit : YELLOW
Fruit : BLACK
Fruit : WHITE

class Player {
    -balance : int
    -coupon: int
}

Player : -withdraw(amount) bool
Player : -useCoupun() bool
Player : -getBalance() int
Player : -getCoupon() int


class Prize {
    <<interface>>
    +getPrize()
    +check()
}

class JackPotPrice {
    -spinner : SpinWheel
    -player : Player
}

JackPotPrice : +getPrize() void
JackPotPrice : +check() void

Prize <|-- JackPotPrice : implements

class PartialJackPotPrice {
    -spinner : SpinWheel
    -player : Player
}

PartialJackPotPrice : +getPrize() void
PartialJackPotPrice : +check() void

Prize <|-- PartialJackPotPrice : implements

class Game {
    -player: Player
    -spinner : SpinWheel
    -cost : int
    -prizes : List<~Prize~>
}

Game : +run() void
Game : -checkPrize() void 
Game : +reset() void

Fruit *-- SpinWheel : have
Player *-- Game : have
SpinWheel *-- Game : have
Prize "*" *-- "1"  Game : have

```