# Version 1: Composition Strategy Pattern

---
## Technical Architecture

### Core Design Principle: Composition over Inheritance
The system uses dependency injection and composition instead of deep inheritance hierarchies. Behaviors are injected into entities through constructors.

---
## Architectural Components

### Abstract Base Classes

#### Animation
Defines rendering contract:
- `draw(GraphicsContext gc, Position position)`
- `getBoundingBox(Position position)`

#### Movement
Defines movement contract:
- `nextPosition(SceneObject current, double deltaTime)`

---
### Concrete Implementations

#### Animation Types
- **AnimationBubbleIdle**: Bubble rendering with circular shape
- **AnimationCoralFish**: Fish rendering with image assets
- **AnimationFishIdle**: Additional fish animation variant

#### Movement Types
- **LinearMovement**: Straight-line movement with direction
- **MovementRebound**: Bouncing behavior on boundaries
- **LoopOutOfBoundsMovement**: Wrapping around screen edges

### Entity Classes
- **SceneObject**: Base class managing state and behavior coordination
- **Fish**: Concrete entity using injected Animation/Movement
- **Bubble**: Concrete entity using injected Animation/Movement

### Value Objects (Records)
- **Position**: Immutable coordinate container
- **Direction**: Immutable direction vector
- **BoundingBox**: Immutable collision boundary definition

### System Components
- **GameLoop** (extends AnimationTimer): Main game loop implementation
- **MainScene** (extends Application): JavaFX application setup
- **DebugUtil**: Debugging and development utilities
- **RandomColor**: Color generation utility

---
## SOLID Principles Implementation

1. **Single Responsibility**: Each Movement class handles specific movement logic; Each Animation class handles specific rendering logic; SceneObject manages coordination only

2. **Open/Closed**: New behaviors added via new Animation/Movement implementations; No modification required to existing classes

3. **Liskov Substitution**: All Animation subtypes interchangeable; All Movement subtypes interchangeable

4. **Interface Segregation**: Animation focuses only on rendering concerns; Movement focuses only on movement concerns

5. **Dependency Inversion**: SceneObject depends on Animation/Movement abstractions; Concrete implementations injected through constructor

## Usage Pattern

```java
// Create specific behaviors
Animation animation = new AnimationCoralFish(30.0);
Movement movement = new MovementRebound();

// Inject dependencies at construction
Fish fish = new Fish(position, movement, animation);
```
---
## Key Benefits

- **Testability**: Each component can be tested independently
- **Flexibility**: Easy to create new entity combinations
- **Maintainability**: Clear separation of concerns
- **Extensibility**: New behaviors don't affect existing code