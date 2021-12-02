package software.steadfast.troupe

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.utils.viewport.ExtendViewport
import com.badlogic.gdx.utils.viewport.Viewport
import games.rednblack.editor.renderer.SceneLoader
import ktx.app.KtxGame
import ktx.app.KtxScreen


class Core : KtxGame<KtxScreen>() {
    private lateinit var mSceneLoader: SceneLoader
    private lateinit var mViewport: Viewport
    private lateinit var mCamera: Camera
    override fun create() {
        mCamera = OrthographicCamera()
        mViewport = ExtendViewport(360f, 640f, 0f, 0f, mCamera)

        //Initialize HyperLap2D's SceneLoader, all assets will be loaded here

        //Initialize HyperLap2D's SceneLoader, all assets will be loaded here
        mSceneLoader = SceneLoader()
        //Load the desired scene with custom viewport
        //Load the desired scene with custom viewport
        mSceneLoader.loadScene("MainScene", mViewport)
    }

    override fun render() {
        super.render()
        mCamera.update(); //Update camera

        //Clear screen
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.15f, 1.0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Apply ViewPort and update SceneLoader's ECS engine
        mViewport.apply();
        mSceneLoader.engine.update(Gdx.graphics.deltaTime);
    }

    override fun resize(width: Int, height: Int) {
        mViewport.update(width, height)
        if (width != 0 && height != 0) mSceneLoader.resize(width, height)
    }

    override fun dispose() {
        mSceneLoader.dispose()
    }
}
