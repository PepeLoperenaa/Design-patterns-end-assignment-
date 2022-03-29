package interfaces

interface BoardingPassBuilder {
    fun reset()
    val passenger: Unit
    val flight: Unit
    val seat: Unit
    val ticket: Unit
}