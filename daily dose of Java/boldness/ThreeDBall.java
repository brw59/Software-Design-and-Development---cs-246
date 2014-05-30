import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.*;

public class ThreeDBall {

   public static void main(String[] args) {
      SimpleUniverse uni = new SimpleUniverse();
      BranchGroup group = new BranchGroup();
      Sphere ball = new Sphere(0.5f);
      group.addChild(ball);


      Color3f color = new Color3f(0, 0, 2);
      BoundingSphere bounds = new BoundingSphere(new Point3d(0, 0, 0), 1000);
      Vector3f direction = new Vector3f(5, -6, -10);
      DirectionalLight light = new DirectionalLight(color, direction);
      light.setInfluencingBounds(bounds);
      group.addChild(light);

      uni.getViewingPlatform().setNominalViewingTransform();
      uni.addBranchGraph(group);

   }

}