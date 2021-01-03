// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelcustom_modelb21 extends EntityModel<Entity> {
	private final ModelRenderer leftleg;
	private final ModelRenderer rightleg;
	private final ModelRenderer bone;
	private final ModelRenderer chest;
	private final ModelRenderer arm;
	private final ModelRenderer fist;
	private final ModelRenderer armright;
	private final ModelRenderer bone2;
	private final ModelRenderer bb_main;

	public Modelcustom_modelb21() {
		textureWidth = 16;
		textureHeight = 16;

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(0.0F, 24.0F, 0.0F);
		leftleg.setTextureOffset(0, 0).addBox(2.0F, -1.0F, -2.0F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 0).addBox(3.0F, -21.0F, -1.0F, 3.0F, 21.0F, 3.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(0.0F, 24.0F, 0.0F);
		rightleg.setTextureOffset(0, 0).addBox(-6.0F, -1.0F, -2.0F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 0).addBox(-5.0F, -21.0F, -1.0F, 3.0F, 21.0F, 3.0F, 0.0F, false);

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);

		chest = new ModelRenderer(this);
		chest.setRotationPoint(0.0F, 0.0F, 0.0F);
		bone.addChild(chest);
		chest.setTextureOffset(0, 0).addBox(-5.0F, -24.0F, -1.0F, 11.0F, 3.0F, 3.0F, 0.0F, false);
		chest.setTextureOffset(0, 0).addBox(-5.0F, -26.0F, -2.0F, 11.0F, 3.0F, 5.0F, 0.0F, false);
		chest.setTextureOffset(0, 0).addBox(-6.0F, -42.0F, -3.0F, 13.0F, 16.0F, 6.0F, 0.0F, false);
		chest.setTextureOffset(0, 0).addBox(-2.0F, -43.0F, -5.0F, 5.0F, 7.0F, 6.0F, 0.0F, false);
		chest.setTextureOffset(0, 0).addBox(-11.0F, -42.0F, -3.0F, 5.0F, 5.0F, 6.0F, 0.0F, false);
		chest.setTextureOffset(0, 0).addBox(7.0F, -42.0F, -3.0F, 4.0F, 5.0F, 6.0F, 0.0F, false);

		arm = new ModelRenderer(this);
		arm.setRotationPoint(-7.0F, 21.0F, -9.0F);
		setRotationAngle(arm, -0.2618F, 0.0F, 0.0F);
		arm.setTextureOffset(0, 0).addBox(-4.0F, -37.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.0F, false);

		fist = new ModelRenderer(this);
		fist.setRotationPoint(0.0F, 6.0F, -27.0F);
		setRotationAngle(fist, -1.3526F, 0.0F, 0.0F);
		fist.setTextureOffset(0, 0).addBox(-11.0F, -28.0F, -5.0F, 4.0F, 10.0F, 4.0F, 0.0F, false);

		armright = new ModelRenderer(this);
		armright.setRotationPoint(0.0F, 24.0F, 0.0F);
		armright.setTextureOffset(0, 0).addBox(8.0F, -38.0F, -2.0F, 3.0F, 16.0F, 4.0F, 0.0F, false);

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(9.0F, -33.0F, 0.0F);
		armright.addChild(bone2);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-10.0F, -28.0F, -15.0F, 2.0F, 2.0F, 9.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		leftleg.render(matrixStack, buffer, packedLight, packedOverlay);
		rightleg.render(matrixStack, buffer, packedLight, packedOverlay);
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
		arm.render(matrixStack, buffer, packedLight, packedOverlay);
		fist.render(matrixStack, buffer, packedLight, packedOverlay);
		armright.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.armright.rotateAngleX = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
	}
}