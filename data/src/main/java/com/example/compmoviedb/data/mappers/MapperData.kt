package com.example.compmoviedb.data.mappers

interface MapperData<E, D> {

    fun mapFromEntity(type: E): D
}