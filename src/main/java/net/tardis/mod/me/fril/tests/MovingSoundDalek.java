package net.tardis.mod.me.fril.tests;

import net.minecraft.client.audio.MovingSound;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.tardis.mod.common.entities.EntityDalek;

public class MovingSoundDalek extends MovingSound {

    private float distance = 0.0F;
    private EntityDalek dalek;
    private SoundEvent soundEvent;

    public MovingSoundDalek(DalekSounds soundIn, EntityDalek entityDalek) {
        super(soundIn.getSoundEvent(), SoundCategory.HOSTILE);
        this.dalek = entityDalek;
        this.soundEvent = soundIn.getSoundEvent();
    }

    /**
     * Like the old updateEntity(), except more generic.
     */
    @Override
    public void update() {

        if (dalek.isShielding()) {

        }
        if (this.dalek.isDead) {
            this.donePlaying = true;
        } else {
            this.xPosF = (float) this.dalek.posX;
            this.yPosF = (float) this.dalek.posY;
            this.zPosF = (float) this.dalek.posZ;
            float f = MathHelper.sqrt(this.dalek.motionX * this.dalek.motionX + this.dalek.motionZ * this.dalek.motionZ);

            if ((double) f >= 0.01D) {
                this.distance = MathHelper.clamp(this.distance + 0.0025F, 0.0F, 1.0F);
                this.volume = 0.0F + MathHelper.clamp(f, 0.0F, 0.5F) * 0.7F;
            } else {
                this.distance = 0.0F;
                this.volume = 0.0F;
            }
        }
    }

    public enum DalekSounds {
        MOVING(SoundEvents.UI_TOAST_IN), SHIELDING(SoundEvents.BLOCK_SNOW_PLACE);

        private SoundEvent soundEvent;

        DalekSounds(SoundEvent sound) {
            soundEvent = sound;
        }

        public SoundEvent getSoundEvent() {
            return soundEvent;
        }
    }
}
