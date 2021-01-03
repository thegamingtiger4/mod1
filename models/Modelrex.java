// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelrex extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer head;
	private final ModelRenderer bb_main;

	public Modelrex() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -10.0F, 0.0F);

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, -10.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, 2.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, true);

		bb_main = new ModelRenderer(this);
		bb_main.setRotationPoint(0.0F, 24.0F, 0.0F);
		bb_main.setTextureOffset(0, 0).addBox(-4.0F, -25.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(3.0F, -25.0F, -5.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-5.0F, -36.0F, -3.0F, 1.0F, 12.0F, 1.0F, 0.0F, false);
		bb_main.setTextureOffset(0, 0).addBox(-5.0F, -36.0F, -3.0F, 3.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		bb_main.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}