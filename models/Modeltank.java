// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modeltank extends EntityModel<Entity> {
	private final ModelRenderer tank;
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;

	public Modeltank() {
		textureWidth = 512;
		textureHeight = 512;

		tank = new ModelRenderer(this);
		tank.setRotationPoint(0.0F, 24.0F, 0.0F);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, 0.0F, 0.0F);
		tank.addChild(body);
		body.setTextureOffset(172, 0).addBox(-11.0F, -19.0F, -8.0F, 22.0F, 19.0F, 16.0F, 0.0F, false);
		body.setTextureOffset(172, 35).addBox(-15.0F, -26.0F, -5.0F, 30.0F, 1.0F, 15.0F, 0.0F, false);
		body.setTextureOffset(0, 76).addBox(11.0F, -10.0F, -29.0F, 4.0F, 10.0F, 22.0F, 0.0F, false);
		body.setTextureOffset(0, 36).addBox(-15.0F, -10.0F, -29.0F, 4.0F, 10.0F, 22.0F, 0.0F, false);
		body.setTextureOffset(146, 162).addBox(-11.0F, -10.0F, -29.0F, 22.0F, 10.0F, 30.0F, 0.0F, false);
		body.setTextureOffset(0, 108).addBox(10.0F, -22.0F, -7.0F, 5.0F, 7.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(109, 6).addBox(10.0F, -24.0F, -6.0F, 5.0F, 3.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(26, 109).addBox(10.0F, -25.0F, -5.0F, 5.0F, 3.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(86, 6).addBox(-15.0F, -25.0F, -5.0F, 5.0F, 3.0F, 13.0F, 0.0F, false);
		body.setTextureOffset(30, 76).addBox(-15.0F, -23.0F, -6.0F, 5.0F, 3.0F, 14.0F, 0.0F, false);
		body.setTextureOffset(30, 36).addBox(-15.0F, -22.0F, -7.0F, 5.0F, 7.0F, 15.0F, 0.0F, false);
		body.setTextureOffset(0, 36).addBox(-11.0F, -25.0F, 0.0F, 1.0F, 6.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(104, 39).addBox(10.0F, -25.0F, 0.0F, 5.0F, 10.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(103, 94).addBox(-18.0F, -15.0F, -2.0F, 7.0F, 3.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(0, 50).addBox(11.0F, -15.0F, -2.0F, 7.0F, 3.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(86, 86).addBox(-15.0F, -25.0F, 8.0F, 30.0F, 7.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(86, 6).addBox(-18.0F, -6.0F, -61.0F, 8.0F, 6.0F, 70.0F, 0.0F, false);
		body.setTextureOffset(86, 86).addBox(9.0F, -6.0F, -61.0F, 8.0F, 6.0F, 70.0F, 0.0F, false);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(13.0F, -1.0F, -26.0F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, 0.0F, 0.0F, -0.6109F);
		cube_r1.setTextureOffset(0, 76).addBox(-1.0F, -5.0F, -40.0F, 4.0F, 6.0F, 5.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-16.0F, -2.0F, -26.0F);
		body.addChild(cube_r2);
		setRotationAngle(cube_r2, 0.0F, 0.0F, 0.6109F);
		cube_r2.setTextureOffset(0, 87).addBox(-1.0F, -5.0F, -40.0F, 4.0F, 6.0F, 5.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(-14.0F, -26.0F, 9.0F);
		body.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.0F, -0.3054F, 0.0F);
		cube_r3.setTextureOffset(18, 36).addBox(-1.0F, -14.0F, 0.0F, 1.0F, 14.0F, 1.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(12.0F, -6.0F, 0.0F);
		body.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, 0.0F, 0.2182F);
		cube_r4.setTextureOffset(0, 152).addBox(-3.0F, -2.0F, -61.0F, 8.0F, 3.0F, 57.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-15.0F, -6.0F, 0.0F);
		body.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, 0.0F, -0.2182F);
		cube_r5.setTextureOffset(73, 162).addBox(-3.0F, -2.0F, -61.0F, 8.0F, 3.0F, 57.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(23.0F, 2.0F, 1.0F);
		body.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, 0.0F, 0.1745F);
		cube_r6.setTextureOffset(0, 0).addBox(-7.0F, -6.0F, -62.0F, 8.0F, 6.0F, 70.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(-18.0F, 0.0F, 1.0F);
		body.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, 0.0F, -0.1745F);
		cube_r7.setTextureOffset(0, 76).addBox(-7.0F, -6.0F, -62.0F, 8.0F, 6.0F, 70.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(-18.0F, -12.0F, -1.0F);
		body.addChild(cube_r8);
		setRotationAngle(cube_r8, -0.1745F, 0.0F, 0.0F);
		cube_r8.setTextureOffset(41, 58).addBox(-1.0F, -1.0F, -10.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		cube_r8.setTextureOffset(101, 107).addBox(36.0F, -1.0F, -10.0F, 1.0F, 1.0F, 11.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-18.0F, -14.0F, -1.0F);
		body.addChild(cube_r9);
		setRotationAngle(cube_r9, -0.1745F, 0.0F, 0.0F);
		cube_r9.setTextureOffset(86, 47).addBox(-1.0F, -1.0F, -13.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);
		cube_r9.setTextureOffset(38, 94).addBox(36.0F, -1.0F, -13.0F, 1.0F, 1.0F, 14.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(22.0F, 4.0F, -10.0F);
		body.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.829F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(86, 94).addBox(-11.0F, -19.0F, -15.0F, 4.0F, 15.0F, 9.0F, 0.0F, false);
		cube_r10.setTextureOffset(86, 22).addBox(-37.0F, -19.0F, -15.0F, 4.0F, 16.0F, 9.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.0F, 1.0F, -15.0F);
		body.addChild(cube_r11);
		setRotationAngle(cube_r11, -1.1345F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(0, 0).addBox(-11.0F, -19.0F, -15.0F, 22.0F, 27.0F, 9.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(11.0F, -20.0F, -8.0F);
		body.addChild(cube_r12);
		setRotationAngle(cube_r12, -0.5236F, 0.0F, 0.0F);
		cube_r12.setTextureOffset(0, 0).addBox(-12.0F, -6.0F, 0.0F, 2.0F, 7.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(13.0F, -20.0F, -7.0F);
		body.addChild(cube_r13);
		setRotationAngle(cube_r13, -0.5236F, 0.0F, 0.0F);
		cube_r13.setTextureOffset(86, 62).addBox(-12.0F, -4.0F, -1.0F, 14.0F, 4.0F, 2.0F, 0.0F, false);
		cube_r13.setTextureOffset(103, 22).addBox(-28.0F, -4.0F, -1.0F, 14.0F, 4.0F, 2.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(-1.0F, -24.0F, -6.0F);
		body.addChild(cube_r14);
		setRotationAngle(cube_r14, -0.5236F, 0.0F, 0.0F);
		cube_r14.setTextureOffset(86, 0).addBox(-14.0F, -2.0F, 0.0F, 30.0F, 2.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-1.0F, -19.0F, -8.0F);
		body.addChild(cube_r15);
		setRotationAngle(cube_r15, -0.5236F, 0.0F, 0.0F);
		cube_r15.setTextureOffset(86, 3).addBox(-14.0F, -2.0F, 0.0F, 30.0F, 2.0F, 1.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		tank.render(matrixStack, buffer, packedLight, packedOverlay);
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