package com.placid_storm.lighting.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelTikiTorch extends ModelBase {

    //fields
    private ModelRenderer Reed[];
    private ModelRenderer Torch[];
    private ModelRenderer Binding;

    public ModelTikiTorch(){
        textureWidth = 64;
        textureHeight = 32;

        Reed[1] = new ModelRenderer(this, 0, 0);
        Reed[1].addBox(-1F, -4F, -1F, 2, 30, 2);
        Reed[1].setRotationPoint(0F, 0F, 1F);
        Reed[1].setTextureSize(64, 32);
        Reed[1].mirror = true;
        setRotation(Reed[1], -0.2617994F, 0F, 0F);

        Reed[2] = new ModelRenderer(this, 0, 0);
        Reed[2].addBox(-1F, -4F, -1F, 2, 30, 2);
        Reed[2].setRotationPoint(0F, 0F, 1F);
        Reed[2].setTextureSize(64, 32);
        Reed[2].mirror = true;
        setRotation(Reed[2], -0.2617994F, -2.356194F, 0F);

        Reed[3] = new ModelRenderer(this, 0, 0);
        Reed[3].addBox(-1F, -4F, -1F, 2, 30, 2);
        Reed[3].setRotationPoint(0F, 0F, 1F);
        Reed[3].setTextureSize(64, 32);
        Reed[3].mirror = true;
        setRotation(Reed[3], -0.2617994F, 2.356194F, 0F);

        Torch[1] = new ModelRenderer(this, 8, 0);
        Torch[1].addBox(-1F, -14F, -1F, 2, 10, 2);
        Torch[1].setRotationPoint(0F, 0F, 1F);
        Torch[1].setTextureSize(64, 32);
        Torch[1].mirror = true;
        setRotation(Torch[1], -0.2617994F, 0F, 0F);

        Torch[2] = new ModelRenderer(this, 8, 0);
        Torch[2].addBox(-1F, -14F, -1F, 2, 10, 2);
        Torch[2].setRotationPoint(0F, 0F, 1F);
        Torch[2].setTextureSize(64, 32);
        Torch[2].mirror = true;
        setRotation(Torch[2], -0.2617994F, -2.373648F, 0F);

        Torch[3] = new ModelRenderer(this, 8, 0);
        Torch[3].addBox(-1F, -14F, -1F, 2, 10, 2);
        Torch[3].setRotationPoint(0F, 0F, 1F);
        Torch[3].setTextureSize(64, 32);
        Torch[3].mirror = true;
        setRotation(Torch[3], -0.2617994F, 2.356194F, 0F);

        Binding = new ModelRenderer(this, 16, 0);
        Binding.addBox(-2F, -1F, -2F, 4, 2, 4);
        Binding.setRotationPoint(0F, 0F, 1F);
        Binding.setTextureSize(64, 32);
        Binding.mirror = true;
        setRotation(Binding, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        setRotationAngles(limbSwing,limbSwingAmount,ageInTicks,netHeadYaw,headPitch,scale,entityIn);
        Reed[1].render(scale);
        Reed[2].render(scale);
        Reed[3].render(scale);
        Torch[1].render(scale);
        Torch[2].render(scale);
        Torch[3].render(scale);
        Binding.render(scale);
    }

    public void renderModel(float scale){
        Reed[1].render(scale);
        Reed[2].render(scale);
        Reed[3].render(scale);
        Torch[1].render(scale);
        Torch[2].render(scale);
        Torch[3].render(scale);
        Binding.render(scale);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z){
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
        super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    }
}
