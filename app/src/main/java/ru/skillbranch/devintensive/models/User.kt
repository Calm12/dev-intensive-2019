package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.utils.Utils
import java.util.*

class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    var lastVisit: Date? = Date(),
    var isOnline: Boolean = false
) {
    constructor(
        id: String,
        firstName: String?,
        lastName: String?
    ) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    data class Builder(
        private var id: String? = null,
        private var firstName: String? = null,
        private var lastName: String? = null,
        private var avatar: String? = null,
        private var rating: Int = 0,
        private var respect: Int = 0,
        private var lastVisit: Date? = Date(),
        private var isOnline: Boolean = false
    ) {
        fun id(id: String) = apply { this.id = id }
        fun firstName(firstName: String?) = apply { this.firstName = firstName }
        fun lastName(lastName: String?) = apply { this.lastName = lastName }
        fun avatar(avatar: String?) = apply { this.avatar = avatar }
        fun rating(rating: Int) = apply { this.rating = rating }
        fun respect(respect: Int) = apply { this.respect = respect }
        fun lastVisit(lastVisit: Date?) = apply { this.lastVisit = lastVisit }
        fun isOnline(isOnline: Boolean) = apply { this.isOnline = isOnline }
        fun build() = User(
            id ?: "-1",
            firstName,
            lastName,
            avatar,
            rating,
            respect,
            lastVisit,
            isOnline
        )
    }


    companion object Factory {
        private var lastId = -1

        fun makeUser(fullName: String?): User {
            lastId++

            val (firstName, lastName) = Utils.parseFullName(fullName)

            return User(
                id = "$lastId",
                firstName = firstName,
                lastName = lastName
            )
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        if (firstName != other.firstName) return false
        if (lastName != other.lastName) return false
        if (avatar != other.avatar) return false
        if (rating != other.rating) return false
        if (respect != other.respect) return false
        if (lastVisit != other.lastVisit) return false
        if (isOnline != other.isOnline) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (firstName?.hashCode() ?: 0)
        result = 31 * result + (lastName?.hashCode() ?: 0)
        result = 31 * result + (avatar?.hashCode() ?: 0)
        result = 31 * result + rating
        result = 31 * result + respect
        result = 31 * result + (lastVisit?.hashCode() ?: 0)
        result = 31 * result + isOnline.hashCode()
        return result
    }
}