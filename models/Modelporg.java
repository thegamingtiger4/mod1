// Made with Blockbench 3.6.6
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelporg extends EntityModel<Entity> {
	private final ModelRenderer head;
	private final ModelRenderer head2;
	private final ModelRenderer beak1;
	private final ModelRenderer beak2;
	private final ModelRenderer body;
	private final ModelRenderer tail;
	private final ModelRenderer wing0;
	private final ModelRenderer wing1;
	private final ModelRenderer feather;
	private final ModelRenderer leg0;
	private final ModelRenderer leg1;

	public Modelporg() {
		textureWidth = 32;
		textureHeight = 32;

		head = new ModelRenderer(this);
		head.setRotationPoint(0.0F, 15.7F, -2.8F);
		head.setTextureOffset(2, 2).addBox(-1.0F, -1.5F, -1.0F, 2.0F, 3.0F, 2.0F, 0.0F, true);

		head2 = new ModelRenderer(this);
		head2.setRotationPoint(0.0F, -2.0F, -1.0F);
		head2.setTextureOffset(10, 0).addBox(-1.0F, -0.5F, -2.0F, 2.0F, 1.0F, 4.0F, 0.0F, true);

		beak1 = new ModelRenderer(this);
		beak1.setRotationPoint(0.0F, -0.5F, -1.5F);
		beak1.setTextureOffset(11, 7).addBox(-0.5F, -1.0F, -0.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);

		beak2 = new ModelRenderer(this);
		beak2.setRotationPoint(0.0F, -1.8F, -2.5F);
		beak2.setTextureOffset(16, 7).addBox(-0.5F, 0.3F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, true);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 16.5F, -3.0F);
		body.setTextureOffset(2, 8).addBox(-1.5F, 0.0F, -1.5F, 3.0F, 6.0F, 3.0F, 0.0F, true);

		tail = new ModelRenderer(this);
		tail.setRotationPoint(0.0F, 21.1F, 1.2F);
		tail.setTextureOffset(22, 1).addBox(-1.5F, -1.0F, -4.0F, 3.0F, 4.0F, 1.0F, 0.0F, true);

		wing0 = new ModelRenderer(this);
		wing0.setRotationPoint(-1.5F, 16.9F, -2.8F);
		wing0.setTextureOffset(19, 8).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 5.0F, 3.0F, 0.0F, true);

		wing1 = new ModelRenderer(this);
		wing1.setRotationPoint(1.5F, 16.9F, -2.8F);
		wing1.setTextureOffset(19, 8).addBox(-0.5F, 0.0F, -1.5F, 1.0F, 5.0F, 3.0F, 0.0F, true);

		feather = new ModelRenderer(this);
		feather.setRotationPoint(0.0F, -2.1F, 0.2F);
		feather.setTextureOffset(2, 18).addBox(0.0F, -4.0F, -2.1F, 0.0F, 5.0F, 4.0F, 0.0F, true);

		leg0 = new ModelRenderer(this);
		leg0.setRotationPoint(-1.0F, 22.0F, -1.0F);
		leg0.setTextureOffset(14, 18).addBox(-0.5F, 0.0F, -2.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);

		leg1 = new ModelRenderer(this);
		leg1.setRotationPoint(1.0F, 22.0F, -1.0F);
		leg1.setTextureOffset(14, 18).addBox(-0.5F, 0.0F, -2.5F, 1.0F, 2.0F, 1.0F, 0.0F, true);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		head.render(matrixStack, buffer, packedLight, packedOverlay);
		head2.render(matrixStack, buffer, packedLight, packedOverlay);
		beak1.render(matrixStack, buffer, packedLight, packedOverlay);
		beak2.render(matrixStack, buffer, packedLight, packedOverlay);
		body.render(matrixStack, buffer, packedLight, packedOverlay);
		tail.render(matrixStack, buffer, packedLight, packedOverlay);
		wing0.render(matrixStack, buffer, packedLight, packedOverlay);
		wing1.render(matrixStack, buffer, packedLight, packedOverlay);
		feather.render(matrixStack, buffer, packedLight, packedOverlay);
		leg0.render(matrixStack, buffer, packedLight, packedOverlay);
		leg1.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.leg0.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}