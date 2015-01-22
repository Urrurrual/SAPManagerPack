/*******************************************************************************************************************
 * Authors:   SanAndreasP
 * Copyright: SanAndreasP
 * License:   Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International
 *                http://creativecommons.org/licenses/by-nc-sa/4.0/
 *******************************************************************************************************************/
package de.sanandrew.core.manpack.mod.client.model;

import de.sanandrew.core.manpack.util.client.helpers.SAPClientUtils;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

/**
 * Created using Tabula 4.1.1
 */
public class ModelSanPlayer
        extends ModelBiped
{
    public ModelRenderer legLeft;
    public ModelRenderer legRight;
    public ModelRenderer armLeft;
    public ModelRenderer armRight;
    public ModelRenderer armLeft2;
    public ModelRenderer armRight2;
    public ModelRenderer body;
    public ModelRenderer breast;
    public ModelRenderer skirt1;
    public ModelRenderer skirt2;
    public ModelRenderer head;
    public ModelRenderer hair;
    public ModelRenderer quadTail1;
    public ModelRenderer quadTail2;
    public ModelRenderer quadTail3;
    public ModelRenderer quadTail4;
    public ModelRenderer hatBase;
    public ModelRenderer hatPt1;
    public ModelRenderer hatPt2;
    public ModelRenderer hatPt3;

    private boolean isArmor;

    public ModelSanPlayer(float scaling, boolean isArmor) {
        super(scaling);
        this.isArmor = isArmor;

        this.textureWidth = 64;
        this.textureHeight = 64;
        this.legLeft = SAPClientUtils.createNewBox(this, 0, 16, true, -1.5F, 0.0F, -1.5F, 3, 12, 3, scaling, 2.5F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.legRight = SAPClientUtils.createNewBox(this, 0, 16, false, -1.5F, 0.0F, -1.5F, 3, 12, 3, 0.0F, -2.5F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.armLeft = SAPClientUtils.createNewBox(this, 40, 16, true, -1.0F, -2.0F, -2.0F, 3, 12, 3, scaling, 5.0F, 2.0F, 0.5F, -0.00331613F, 0.0F, -0.09983283F);
        this.armRight = SAPClientUtils.createNewBox(this, 40, 16, false, -3.0F, -2.0F, -2.0F, 3, 12, 3, scaling, -4.0F, 2.0F, 0.5F, 0.0F, 0.0F, 0.09983283F);
        this.armLeft2 = SAPClientUtils.createNewBox(this, 40, 32, true, -1.0F, 5.0F, -2.0F, 3, 5, 3, scaling, 5.0F, 2.0F, 0.5F, -0.00331613F, 0.0F, -0.09983283F);
        this.armRight2 = SAPClientUtils.createNewBox(this, 40, 32, false, -3.0F, 5.0F, -2.0F, 3, 5, 3, scaling, -4.0F, 2.0F, 0.5F , 0.0F, 0.0F, 0.09983283F);
        this.body = SAPClientUtils.createNewBox(this, 16, 16, false, -4.0F, 0.0F, -2.0F, 8, 12, 4, scaling, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.breast = SAPClientUtils.createNewBox(this, 0, 54, false, -3.5F, 0.0F, 0.0F, 7, 3, 3, scaling, 0.0F, 3.0F, -3.5F, 0.87266463F, 0.0F, 0.0F);
        this.skirt1 = SAPClientUtils.createNewBox(this, 16, 36, false, -4.5F, 8.0F, -2.5F, 9, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.skirt2 = SAPClientUtils.createNewBox(this, 16, 44, false, -4.5F, 11.0F, -3.0F, 9, 4, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.head = SAPClientUtils.createNewBox(this, 28, 0, false, -3.5F, -7.0F, -3.5F, 7, 7, 7, scaling, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.hair = SAPClientUtils.createNewBox(this, 0, 0, false, -3.5F, -7.0F, -3.5F, 7, 7, 7, scaling, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.quadTail1 = SAPClientUtils.createNewBox(this, 0, 40, true, -1.5F, 3.0F, 1.0F, 3, 10, 3, scaling, 0.0F, -3.0F, 0.0F, 0.52359878F, 0.0F, -2.26892803F);
        this.quadTail2 = SAPClientUtils.createNewBox(this, 0, 40, false, -1.5F, 3.0F, 1.0F, 3, 10, 3, scaling, 0.0F, -3.0F, 0.0F, 0.52359878F, 0.0F, 2.26892803F);
        this.quadTail3 = SAPClientUtils.createNewBox(this, 0, 32, true, -0.5F, 3.0F, 0.9F, 2, 6, 2, scaling, 0.0F, -3.0F, 0.0F, 0.63739424F, 0.0F, -0.61086524F);
        this.quadTail4 = SAPClientUtils.createNewBox(this, 0, 32, false, -1.5F, 3.0F, 0.9F, 2, 6, 2, scaling, 0.0F, -3.0F, 0.0F, 0.63739424F, 0.0F, 0.61086524F);
        this.hatBase = SAPClientUtils.createNewBox(this, 0, 0, false, -5.0F, -8.5F, -4.5F, 10, 2, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.hatPt1 = SAPClientUtils.createNewBox(this, 0, 11, false, -3.0F, -9.5F, -3.0F, 6, 2, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.hatPt2 = SAPClientUtils.createNewBox(this, 29, 0, false, -2.0F, -11.5F, -2.0F, 4, 2, 4, scaling, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.hatPt3 = SAPClientUtils.createNewBox(this, 45, 0, false, -1.5F, -13.5F, -1.5F, 3, 2, 3, scaling, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);

        this.body.addChild(this.breast);
        this.head.addChild(this.quadTail1);
        this.head.addChild(this.quadTail2);
        this.head.addChild(this.quadTail3);
        this.head.addChild(this.quadTail4);
        this.hatBase.addChild(this.hatPt1);
        this.hatBase.addChild(this.hatPt2);
        this.hatBase.addChild(this.hatPt3);
    }

    @Override
    public void render(Entity entity, float limbSwing, float limbSwingAmount, float rotFloat, float rotYaw, float rotPitch, float partTicks) {
        this.setRotationAngles(limbSwing, limbSwingAmount, rotFloat, rotYaw, rotPitch, partTicks, entity);

        if( !this.isArmor ) {
            GL11.glPushMatrix();
            GL11.glTranslatef(this.head.offsetX, this.head.offsetY, this.head.offsetZ);
            GL11.glTranslatef(this.head.rotationPointX * partTicks, this.head.rotationPointY * partTicks, this.head.rotationPointZ * partTicks);
            GL11.glScaled(1.1D, 1.1D, 1.1D);
            GL11.glTranslatef(-this.head.offsetX, -this.head.offsetY, -this.head.offsetZ);
            GL11.glTranslatef(-this.head.rotationPointX * partTicks, -this.head.rotationPointY * partTicks, -this.head.rotationPointZ * partTicks);
            this.head.render(partTicks);
            GL11.glPopMatrix();

            GL11.glPushMatrix();
            GL11.glTranslatef(this.hair.offsetX, this.hair.offsetY, this.hair.offsetZ);
            GL11.glTranslatef(this.hair.rotationPointX * partTicks, this.hair.rotationPointY * partTicks, this.hair.rotationPointZ * partTicks);
            GL11.glScaled(1.15D, 1.15D, 1.15D);
            GL11.glTranslatef(-this.hair.offsetX, -this.hair.offsetY, -this.hair.offsetZ);
            GL11.glTranslatef(-this.hair.rotationPointX * partTicks, -this.hair.rotationPointY * partTicks, -this.hair.rotationPointZ * partTicks);
            this.hair.render(partTicks);
            GL11.glPopMatrix();
        } else {
            this.hatBase.render(partTicks);
        }

        this.armLeft.render(partTicks);
        this.armRight.render(partTicks);
        this.legLeft.render(partTicks);
        this.legRight.render(partTicks);
        this.body.render(partTicks);
        this.skirt1.render(partTicks);
        this.skirt2.render(partTicks);

        GL11.glPushMatrix();
        GL11.glTranslatef(this.armLeft2.offsetX, this.armLeft2.offsetY, this.armLeft2.offsetZ);
        GL11.glTranslatef(this.armLeft2.rotationPointX * partTicks + 0.025F, this.armLeft2.rotationPointY * partTicks, this.armLeft2.rotationPointZ * partTicks);
        GL11.glScaled(1.05D, 1.05D, 1.05D);
        GL11.glTranslatef(-this.armLeft2.offsetX, -this.armLeft2.offsetY, -this.armLeft2.offsetZ);
        GL11.glTranslatef(-this.armLeft2.rotationPointX * partTicks - 0.025F, -this.armLeft2.rotationPointY * partTicks, -this.armLeft2.rotationPointZ * partTicks);
        this.armLeft2.render(partTicks);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.armRight2.offsetX, this.armRight2.offsetY, this.armRight2.offsetZ);
        GL11.glTranslatef(this.armRight2.rotationPointX * partTicks - 0.025F, this.armRight2.rotationPointY * partTicks, this.armRight2.rotationPointZ * partTicks);
        GL11.glScaled(1.05D, 1.05D, 1.05D);
        GL11.glTranslatef(-this.armRight2.offsetX, -this.armRight2.offsetY, -this.armRight2.offsetZ);
        GL11.glTranslatef(-this.armRight2.rotationPointX * partTicks + 0.025F, -this.armRight2.rotationPointY * partTicks, -this.armRight2.rotationPointZ * partTicks);
        this.armRight2.render(partTicks);
        GL11.glPopMatrix();
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float rotFloat, float rotYaw, float rotPitch, float partTicks, Entity entity) {
        super.setRotationAngles(limbSwing, limbSwingAmount, rotFloat, rotYaw, rotPitch, partTicks, entity);

        this.head.rotationPointY = this.hatBase.rotationPointY = this.hair.rotationPointY = this.bipedHead.rotationPointY;

        this.setRotateAngle(this.head, this.bipedHead.rotateAngleX, this.bipedHead.rotateAngleY, this.bipedHead.rotateAngleZ);
        this.setRotateAngle(this.hatBase, this.bipedHead.rotateAngleX, this.bipedHead.rotateAngleY, this.bipedHead.rotateAngleZ);
        this.setRotateAngle(this.hair, this.bipedHead.rotateAngleX, this.bipedHead.rotateAngleY, this.bipedHead.rotateAngleZ);
        this.setRotateAngle(this.body, this.bipedBody.rotateAngleX * 0.5F, this.bipedBody.rotateAngleY, this.bipedBody.rotateAngleZ);
        this.setRotateAngle(this.skirt1, this.bipedBody.rotateAngleX * 0.5F, this.bipedBody.rotateAngleY, this.bipedBody.rotateAngleZ);
        this.setRotateAngle(this.skirt2, this.bipedBody.rotateAngleX * 0.5F, this.bipedBody.rotateAngleY, this.bipedBody.rotateAngleZ);
        this.setRotateAngle(this.armLeft, this.bipedLeftArm.rotateAngleX, this.bipedLeftArm.rotateAngleY, this.bipedLeftArm.rotateAngleZ);
        this.setRotateAngle(this.armLeft2, this.bipedLeftArm.rotateAngleX, this.bipedLeftArm.rotateAngleY, this.bipedLeftArm.rotateAngleZ);
        this.setRotateAngle(this.armRight, this.bipedRightArm.rotateAngleX, this.bipedRightArm.rotateAngleY, this.bipedRightArm.rotateAngleZ);
        this.setRotateAngle(this.armRight2, this.bipedRightArm.rotateAngleX, this.bipedRightArm.rotateAngleY, this.bipedRightArm.rotateAngleZ);

        if( this.isRiding ) {
            this.setRotateAngle(this.legLeft, this.bipedLeftLeg.rotateAngleX, this.bipedLeftLeg.rotateAngleY, this.bipedLeftLeg.rotateAngleZ);
            this.setRotateAngle(this.legRight, this.bipedRightLeg.rotateAngleX, this.bipedRightLeg.rotateAngleY, this.bipedRightLeg.rotateAngleZ);
        } else {
            this.setRotateAngle(this.legLeft, this.bipedLeftLeg.rotateAngleX * 0.5F, this.bipedLeftLeg.rotateAngleY, this.bipedLeftLeg.rotateAngleZ);
            this.setRotateAngle(this.legRight, this.bipedRightLeg.rotateAngleX * 0.5F, this.bipedRightLeg.rotateAngleY, this.bipedRightLeg.rotateAngleZ);
        }

        if( this.isSneak ) {
            this.legLeft.rotationPointZ = 3.0F;
            this.legRight.rotationPointZ = 3.0F;
            this.legLeft.rotateAngleX -= 0.15F;
            this.legRight.rotateAngleX -= 0.15F;
            this.armLeft.rotateAngleX += 0.2F;
            this.armLeft2.rotateAngleX += 0.2F;
            this.armRight.rotateAngleX += 0.2F;
            this.armRight2.rotateAngleX += 0.2F;
        } else {
            this.legLeft.rotationPointZ = 0.0F;
            this.legRight.rotationPointZ = 0.0F;
        }
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}