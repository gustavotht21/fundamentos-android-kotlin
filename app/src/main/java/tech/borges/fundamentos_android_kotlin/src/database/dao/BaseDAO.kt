package tech.borges.fundamentos_android_kotlin.src.database.dao

abstract class BaseDAO<TModel> {
    abstract fun get(): List<TModel>
    abstract fun store(data: TModel)
}