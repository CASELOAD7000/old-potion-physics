package me.caseload.oldpotionphysics.util;

import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class PhysicsHelper {

    public static Vector getVelocity(double x, double y, double z, float speed, float divergence) {
        Vector randomVector = new Vector(
                MathHelper.nextTriangular(0.0, 0.0172275 * (double)divergence),
                MathHelper.nextTriangular(0.0, 0.0172275 * (double)divergence),
                MathHelper.nextTriangular(0.0, 0.0172275 * (double)divergence)
        );

        return new Vector(x, y, z).normalize().add(randomVector).multiply((double) speed);
    }

    public static Vector getVelocity(Entity shooter, float pitch, float yaw, float roll, float speed, float divergence) {
        float f = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        float g = -MathHelper.sin((pitch + roll) * 0.017453292F);
        float h = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);

        Vector shooterVelocity = shooter.getVelocity().clone();
        shooterVelocity.setY(shooter.isOnGround() ? 0.0 : shooterVelocity.getY());

        return getVelocity((double) f, (double) g, (double) h, speed, divergence).add(shooterVelocity);
    }
}
