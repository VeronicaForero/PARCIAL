import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val candidatos = listOf(
        Candidato("Candidato Melany", "Partido A"),
        Candidato("Candidato Daniela", "Partido B"),
        Candidato("Candidato Veronica", "Partido C")
    )

    fun totalVotos(): Int {
        var total = 0
        for (candidato in candidatos) {
            total += candidato.totalVotos()
        }
        return total
    }

    fun costoPromedio(): Double {
        val totalVotos = totalVotos()
        var costoTotal = 0
        for (candidato in candidatos) {
            costoTotal += candidato.calcularCostoCampana()
        }
        return if (totalVotos > 0) costoTotal.toDouble() / totalVotos else 0.0
    }

    while (true) {
        println("Menú:")
        println("1. Votar por un candidato")
        println("2. Calcular costo de campaña de un candidato")
        println("3. Vaciar todas las urnas de la votación")
        println("4. Conocer el número total de votos")
        println("5. Porcentaje de votos obtenidos por cada candidato")
        println("6. Costo promedio de campaña en las elecciones")
        println("7. Salir")
        print("Seleccione una opción: ")

        when (scanner.nextInt()) {
            1 -> {
                println("Seleccione el medio de influencia:")
                println("1. Internet")
                println("2. Radio")
                println("3. Televisión")
                val medio = scanner.nextInt()

                println("Seleccione el candidato:")
                candidatos.forEachIndexed { index, candidato -> println("${index + 1}. ${candidato.nombre}") }
                val candidatoIndex = scanner.nextInt() - 1

                when (medio) {
                    1 -> candidatos[candidatoIndex].votosInternet++
                    2 -> candidatos[candidatoIndex].votosRadio++
                    3 -> candidatos[candidatoIndex].votosTelevision++
                    else -> println("Medio no válido.")
                }
                println("Voto registrado.")
            }
            2 -> {
                println("Seleccione el candidato:")
                candidatos.forEachIndexed { index, candidato -> println("${index + 1}. ${candidato.nombre}") }
                val candidatoIndex = scanner.nextInt() - 1
                val costo = candidatos[candidatoIndex].calcularCostoCampana()
                println("El costo de campaña de ${candidatos[candidatoIndex].nombre} es: $costo")
            }
            3 -> {
                candidatos.forEach { candidato ->
                    candidato.votosInternet = 0
                    candidato.votosRadio = 0
                    candidato.votosTelevision = 0
                }
                println("Urnas vaciadas.")
            }
            4 -> {
                candidatos.forEach { candidato ->
                    println("El número total de votos para ${candidato.nombre} es ${candidato.totalVotos()}")
                }
            }
            5 -> {
                val totalVotos = totalVotos()
                if (totalVotos > 0) {
                    candidatos.forEach { candidato ->
                        val porcentaje = (candidato.totalVotos().toDouble() / totalVotos) * 100
                        println("${candidato.nombre} obtuvo el $porcentaje% de los votos")
                    }
                } else {
                    println("No hay votos registrados.")
                }
            }
            6 -> {
                candidatos.forEach { candidato ->
                    val costoPromedio = candidato.costoPromedioPorVoto()
                    println("El costo promedio por voto para ${candidato.nombre} es: $costoPromedio")
                }
            }
            7 -> {
                println("Saliendo...")
                break
            }
            else -> println("Opción no válida.")
        }
    }
}