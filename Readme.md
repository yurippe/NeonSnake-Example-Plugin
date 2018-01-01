# Example Plugin for NeonSnake

## How to get started
 * Build [NeonSnake](https://github.com/yurippe/NeonSnake)
 * Copy `NeonSnake-X.X.jar` into `libs/`
 * Edit `pom.xml` NeonSnake version in `<neonsnake.version>X.X</neonsnake.version>`
 * Run `mvn clean package`
 * Copy jarfile into `Neo4J/plugins`, together with NeonSnake
 * Add the classpath to NeonSnake's plugin list
   - If you have no plugins active at the moment
    ```
    MATCH (n:NeonSnake) SET n.plugins = ["dk.atomit.NeonSnake.Examples.ExamplePlugin"]
    ```
   - If you already have plugins active
   ```
    MATCH (n:NeonSnake) SET n.plugins = n.plugins + ["dk.atomit.NeonSnake.Examples.ExamplePlugin"]
    ```

You may have to restart Neo4J to be able to load the new plugin.