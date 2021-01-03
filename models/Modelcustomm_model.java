// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelcustomm_model extends EntityModel<Entity> {
	private final ModelRenderer engine;
	private final ModelRenderer seating;
	private final ModelRenderer bb_main;

	public Modelcustomm_model() {
		textureWidth = 256;
		textureHeight = 256;

		engine = new ModelRenderer(this);
		engine.setRotationPoint(0.0F, 24.0F, 0.0F);
		engine.setTextureOffset(0, 0).addBox(-3.0F, -1.0F, -49.0F, 5.0F, 1.0F, 77.0F, 0.0F, false);
		engine.setTextureOffset(0, 0).addBox(-5.0F, -7.0F, 3.0F, 9.0F, 7.0F, 25.0F, 0.0F, false);
		engine.setTextureOffset(120, 39).addBox(-8.0F, -7.0F, 1.0F, 3.0F, 7.0F, 27.0F, 0.0F, false);
		engine.setTextureOffset(87, 32).addBox(4.0F, -7.0F, -2.0F, 3.0F, 7.0F, 27.0F, 0.0F, false);
		engine.setTextureOffset(123, 78).addBox(-11.0F, -7.0F, -2.0F, 6.0F, 7.0F, 28.0F, 0.0F, false);
		engine.setTextureOffset(0, 78).addBox(7.0F, -7.0F, -1.0F, 3.0F, 7.0F, 23.0F, 0.0F, false);
		engine.setTextureOffset(0, 78).addBox(-14.0F, -7.0F, -1.0F, 5.0F, 7.0F, 25.0F, 0.0F, false);
		engine.setTextureOffset(87, 0).addBox(-4.0F, -8.0F, 3.0F, 7.0F, 7.0F, 25.0F, 0.0F, false);
		engine.setTextureOffset(0, 32).addBox(-4.0F, -13.0F, 3.0F, 7.0F, 7.0F, 25.0F, 0.0F, false);

		seating = new ModelRenderer(this);
		seating.setRotationPoint(0.0F, 24.0F, 0.0F);
		seating.setTextureOffset(0, 78).addBox(-5.0F, -3.0F, -26.0F, 9.0F, 2.0F, 54.0F, 0.0F, false);
		seating.setTextureOffset(0, 0).addBox(-5.0F, -22.0F, 4.0F, 10.0F, 20.0F, 1.0F, 0.0F, false);
		seating.setTextureOffset(72, 78).addBox(-5.0F, -5.0F, -13.0F, 9.0F, 5.0F, 11.0F, 0.0F, false);
		seating.setTextureOffset(39, 32).addBox(-1.0F, -3.0F, -16.0F, 1.0F, 7.0F, 17.0F, 0.0F, false);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(43, 0).addBox(4.0F, -16.0F, -7.0F, 1.0F, 16.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(39, 30).addBox(-6.0F, -16.0F, -7.0F, 1.0F, 16.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(72, 78).addBox(-3.0F, -8.0F, -48.0F, 5.0F, 8.0F, 41.0F, 0.0F, false);
		bb_main.setTextureOffset(12, 21).addBox(4.0F, -16.0F, -7.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 21).addBox(-9.0F, -16.0F, -7.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		bb_main.setTextureOffset(126, 0).addBox(1.0F, -9.0F, -52.0F, 3.0F, 5.0F, 18.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 108).addBox(-4.0F, -9.0F, -52.0F, 3.0F, 5.0F, 18.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 32).addBox(-2.0F, -5.0F, -55.0F, 5.0F, 5.0F, 7.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks,
			float netHeadYaw, float headPitch) {
		// previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		engine.render(matrixStack, buffer, packedLight, packedOverlay);
		seating.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}