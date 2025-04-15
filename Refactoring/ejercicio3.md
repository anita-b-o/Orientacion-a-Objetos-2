# Ejercicio 3

Dado el siguiente código implementado en la clase Document y que calcula algunas estadísticas del mismo:


```java

public class Document {
    List<String> words;
  
    public long characterCount() {
 	    long count = this.words
            .stream()
            .mapToLong(w -> w.length())
            .sum();
    	return count;
	}
    public long calculateAvg() {
    	long avgLength = this.words
            .stream()
            .mapToLong(w -> w.length())
            .sum() / this.words.size();
 	    return avgLength;
	}
// Resto del código que no importa
}

```

### Tareas:

1. Enumere los code smell y que refactorings utilizará para solucionarlos.
2. Aplique los refactorings encontrados, mostrando el código refactorizado luego de aplicar cada uno.
3. Analice el código original y detecte si existe un problema al calcular las estadísticas. Explique cuál es el error y en qué casos se da ¿El error identificado sigue presente luego de realizar los refactorings? En caso de que no esté presente, ¿en qué momento se resolvió? De acuerdo a lo visto en la teoría, ¿podemos considerar esto un refactoring?

#### Code Smell
- INAPPROPIATE INTIMACY
- PRIMITIBE OBSESSION 
- TEMPORALY VARIABLE 
#### Refactoring
- ENCAPSULATE FIELD
- REPLACE ALGORITHM WITH LIBRERY FUNCTION
- REPLACE TEMP WITH QUERY

*El problema es que si el arreglo es vacio, divide por 0, y se resuelve luego de aplicar el refactoring REPLACE ALGORITHM WITH LIBRERY FUNCTION*


INAPPROPIATE INTIMACY -> ENCAPSULATE FIELD

```java

public class Document {
    private List<String> words;
  
    public long characterCount() {
 	    long count = this.words
            .stream()
            .mapToLong(w -> w.length())
            .sum();
    	return count;
	}
    public long calculateAvg() {
    	long avgLength = this.words
            .stream()
            .mapToLong(w -> w.length())
            .sum() / this.words.size();
 	    return avgLength;
	}
// Resto del código que no importa
}

```
PRIMITIVE OBSESSION -> REPLACE ALGORITHM WITH LIBRARY FUNCTION 


```java

public class Document {
    private List<String> words;
  
    public long characterCount() {
 	    long count = this.words
            .stream()
            .mapToLong(w -> w.length())
            .sum();
    	return count;
	}
    public long calculateAvg() {
    	long avgLength = this.words
            .stream()
            .mapToLong(w -> w.length())
            .average().orElse(0);
 	    return avgLength;
	}
// Resto del código que no importa
}

```
TEMPORALY VARIABLE -> REPLACE TEMP WITH QUERY


```java

public class Document {
    private List<String> words;
  
    public long characterCount() { 
    	return this.words
            .stream()
            .mapToLong(w -> w.length())
            .sum();;
	}
    public long calculateAvg() {
 	    return this.words
            .stream()
            .mapToLong(w -> w.length())
            .average().orElse(0);;
	}
// Resto del código que no importa
}

```
