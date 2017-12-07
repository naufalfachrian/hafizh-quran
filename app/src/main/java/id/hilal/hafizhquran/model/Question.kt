package id.hilal.hafizhquran.model

import java.io.Serializable

data class Question (
        val title: String,
        val options: List<Option>?,
        val answer: String?,
        val type: QuestionType
) : Serializable {
}