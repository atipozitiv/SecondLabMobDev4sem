package com.example.secondlabmobdev4sem

class Character {
    var id: Int = 0
    var name: String = ""
    var species: String = ""
    var image: String = ""

    fun getType(): String {
        if(species == "Human") return "image"
        if(species == "Alien") return "name"
        return "species"
    }
}



data class Root (
    var info: Info? = null,
    var results: MutableList<Result>? = null,
)
data class Info (
    var count: Int? = null,
    var pages: Int? = null,
    var next: String? = null,
    var prev: String? = null
)
data class Result (
    var id: Int? = null,
    var name: String? = null,
    var status: String? = null,
    var species: String? = null,
    var type: String? = null,
    var gender: String? = null,
    var origin: Origin? = null,
    var location: Location? = null,
    var image: String? = null,
    var episode: MutableList<String>? = null,
    var url: String? = null,
    var created: String? = null
)
data class Origin (
    var name: String? = null,
    var url: String? = null
)
data class Location (
    var name: String? = null,
    var url: String? = null
)