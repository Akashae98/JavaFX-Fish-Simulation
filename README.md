# 🐠 JavaFX Fish Simulation

<div align="center">

![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-21-blue?style=for-the-badge&logo=javafx&logoColor=white)
![Maven](https://img.shields.io/badge/Apache%20Maven-3.6%2B-red?style=for-the-badge&logo=apache-maven&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green?style=for-the-badge)

*A simulation that explores software architecture paradigms and integrates real quantum randomness.*

</div>

---

## 🚀 Project Evolution & Learning Goals

> **This isn't just a static project; it's a technical journey.** Each version represents a deep dive into a different architectural approach, tackling the same problem with increasingly sophisticated solutions.

### 📊 Technical Roadmap

| **Version** | **Branch** | **Paradigm** | **Key Concept** | **Status** |
|-------------|------------|--------------|-----------------|------------|
| **v1.0** | [`version-1`](../../tree/version-1) |  🔷 Composition & Strategy | Modern design favoring composition over inheritance | ✅ Complete |
| **v1.1** | [`quantum_experiment`](../../tree/quantum_experiment) | ⚛️ Quantum Randomness | Real quantum numbers from ANU API (baaed on v.1.0)| ✅ Complete |
| **v2.0** | [`ECS`](../../tree/ECS_%2333) | 🏗️ ECS Architecture | Pure Entity-Component-System for data-oriented design | 🚧 In Progress |

---

## 🧩 Architectural Evolution

<div align="center">

---

</div>

### 🔷 Version 1: Composition & Strategy Pattern

**Core Design**: Composition over Inheritance with Dependency Injection

The system uses composition and the Strategy pattern to build flexible entities. Each SceneObject is composed of injectable behaviors:

- **Animation strategy**: Handles rendering (e.g.,AnimationCoralFish, AnimationBubbleIdle, AnimationFishIdle)
- **Movement strategy**: Handles movement (e.g.,MovementRebound, LinearMovement)

```java
// Usage: Inject behaviors at construction
Animation animation = new AnimationCoralFish(30.0);
Movement movement = new MovementRebound();
Fish fish = new Fish(position, movement, animation);
```

**Key Benefits**: Flexible, extensible, testable, and SOLID-compliant design.

> 📖 **Implementation Details**: Available in [`version-1`](../../tree/version-1) branch

<div align="center">

---

</div>

### ⚛️ Version 1.1: The Quantum Advantage

<div align="center">
<img src="https://img.shields.io/badge/Quantum-Powered-blueviolet?style=flat-square&logo=atom&logoColor=white" alt="Quantum Powered">
</div>

This version integrates with the **Australian National University (ANU) Quantum Random Number Generator**. This API provides true randomness by measuring the quantum fluctuations of the vacuum, based on Heisenberg's uncertainty principle.

#### 🔬 Why Quantum?
- ✨ **True randomness**: Replaces Java's pseudo-random generators (Random, Math.random())
- 🐟 **Authentic behavior**: Fish behave with genuine, physical unpredictability
- 🧬 **Real physics**: Based on fundamental quantum mechanical principles

> 📚 **API Documentation**: [ANU Quantum RNG](https://qrng.anu.edu.au/contact/api-documentation/)  
> 📖 **Implementation Details**: Available in [`quantum_experiment`](../../tree/quantum_experiment) branch

<div align="center">

---

</div>

###  🏗️ Version 2: Entity-Component-System (ECS) Architecture

To explore the limits of composition and data-oriented design, this version implements a pure ECS architecture:

- **Entities** become mere identifiers, devoid of logic
- **Components** become pure data containers (e.g., PositionComponent, ColliderComponent, SpriteComponet)
- **Systems** become processors that act on all entities possessing required components

**Why switch to ECS?**
- 🔄 **Flexibility**: Components can be combined in different ways for varied entity types
- 🧩 **Collision control**: easier to implement and manage collision systems across thousands of objects
- ⚡ **Scalability**: data-oriented design optimizes performance for large-scale simulations
- 🎮 **Industry alignment**: ECS is widely used in modern game engines (Unity, Bevy, etc.)

This experimental shift aims to prepare the simulation for **collision detection between fishes, bubbles, and corals**, enabling richer interactions and emergent behaviors.

> 📖 **Actually working**: Available in [`ECS`](../../tree/ECS_%2333) branch

<div align="center">

---

</div>

---

## ⚙️ Prerequisites & Setup

| **Requirement** | **Version** | **Purpose** |
|-----------------|-------------|-------------|
| ☕ **JDK** | 21+ | Core runtime and language features |
| 🔨 **Maven** | 3.9.5+ | Dependency and build management |
| 🌐 **Internet** | - | Maven dependencies and Quantum API |

**Recommended IDEs:**
- 🚀 **IntelliJ IDEA** (Ultimate/Community + Maven plugin)
- 🔵 **NetBeans** (Full Java SE support)
- 💚 **VS Code** + Java Extension Pack

---

## 🚀 How to Run

### 🎯 Method 1: Maven (Recommended)

```bash
# 1. Switch to desired version branch
git checkout version-1

# 2. Execute the Maven goal for JavaFX
mvn clean javafx:run
```

### 🔵 Method 2: NetBeans

<div align="center">
<img src="https://img.shields.io/badge/NetBeans-Ready-blue?style=flat-square&logo=apache-netbeans-ide&logoColor=white" alt="NetBeans Ready">
</div>

1. **Switch to desired branch** (`git checkout branch-name`)
2. **Open project** in NetBeans
3. **Click Run button** - that's it!

Each branch includes `nbactions.xml` that automatically triggers the Maven plugin.

### 🚀 Method 3: IntelliJ IDEA

<div align="center">
<img src="https://img.shields.io/badge/IntelliJ-Configuration%20Required-orange?style=flat-square&logo=intellij-idea&logoColor=white" alt="IntelliJ Configuration Required">
</div>

> ⚠️ **Important**: Do **NOT** run directly from the IDE's run button.

**Steps:**
1. **Switch to desired branch** (`git checkout branch-name`)
2. Open the **Maven Toolbar** (View → Tool Windows → Maven)
3. Navigate to the **javafx plugin**
4. Run the **javafx:run** goal

<details>
<summary><strong>🛠️ Alternative: Manual Run Configuration (Click to expand)</strong></summary>

If you prefer to use IntelliJ's run configuration instead of Maven:

1. **Create a new Application Run Configuration**
2. **Set Main Class** to your application's main class
3. **Configure VM Options**: Add the module path pointing to your Maven dependencies
   - Go to VM Options field
   - Add JavaFX module path (usually in `~/.m2/repository/org/openjfx/`)
   - Set module path and add modules as needed
4. **Run the configuration**

> ⚠️ **Note**: Ensure Maven has downloaded all dependencies first (`mvn clean compile`).  
> 💡 **Tip**: Maven method is usually simpler and more reliable.

</details>

---

## 📁 Navigating the Versions

Each version branch contains its own source code, resources, and implementation details:

- 🏗️ **Architecture implementation** - See how each design pattern is applied
- ⚡ **Specific execution setup** - Maven configuration and dependencies for that version  
- 🎯 **Code examples** - Real implementations of the architectural concepts
- 📁 **Project structure** - How components are organized in each approach

---

## 🛠️ Built With

<div align="center">

| Technology | Purpose | Version |
|------------|---------|---------|
| ☕ **Java 21** | Programming language | 21 |
| 🎨 **JavaFX 21** | Graphics and UI library | 21 |
| 🔨 **Apache Maven** | Build management | 3.9.5 |
| 📄 **GSON** | JSON processing for Quantum API | Latest |
| ⚛️ **ANU Quantum API** | Source of true random numbers | v1 |

</div>

---

<div align="center">

### 🌟 Ready to explore different architectural paradigms?

**Choose your journey:**

[![Version 1](https://img.shields.io/badge/v1.0-Composition%20%26%20Strategy-orange?style=for-the-badge)](../../tree/version-1)
[![Version 1.1](https://img.shields.io/badge/v1.1-Quantum%20Random-blueviolet?style=for-the-badge)](../../tree/quantum_experiment)
[![Version 2](https://img.shields.io/badge/v2.0-Entity%20Component%20System-blue?style=for-the-badge)](../../tree/ECS_%2333)

</div>

---

## 🤝 Contributing

Found a bug? Contributions are welcome!

---

## 📄 License

This project is licensed under the MIT License.


---
<div align="center">

*Made with ❤️ for learning software architecture*

🐛 [Report Issues](../../issues)  • ⭐ [Star this repo](../../stargazers) • 🚀 [Latest Release](../../releases)

</div>
