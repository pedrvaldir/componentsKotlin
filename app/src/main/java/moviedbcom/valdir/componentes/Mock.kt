package moviedbcom.valdir.componentes

class Mock private constructor() {

    // será usado companion object para não rpecisar instanciar a classe
    companion object{
        fun getList(): List<String> = listOf("GRAMAS", "KG", "ARROBA", "TONELADA")
    }

    /* desta outra forma tbm daria mas teria que criar um nome
            object TEST{
        fun getList(): List<String> = listOf("GRAMAS", "KG", "ARROBA", "TONELADA")
    }
    */
}