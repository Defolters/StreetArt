package io.github.streetart.data

class ArtsRepository : ArtsDataSource{
    override fun getArts(forceUpdate: Boolean, callback: ArtsDataSource.LoadArtsCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getArt(id: String, callback: ArtsDataSource.GetArtCallback) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun clearAllArts() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {

        private var repository: ArtsRepository? = null

        fun getRepository() : ArtsRepository {
            return repository ?: ArtsRepository()
                .apply { repository = this }
        }
    }
}