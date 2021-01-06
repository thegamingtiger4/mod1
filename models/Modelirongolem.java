// Made with Blockbench 3.7.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Modelirongolem extends EntityModel<Entity> {
	private final ModelRenderer body;
	private final ModelRenderer cube_r1;
	private final ModelRenderer rightleg;
	private final ModelRenderer cube_r2;
	private final ModelRenderer cube_r3;
	private final ModelRenderer cube_r4;
	private final ModelRenderer cube_r5;
	private final ModelRenderer cube_r6;
	private final ModelRenderer cube_r7;
	private final ModelRenderer cube_r8;
	private final ModelRenderer cube_r9;
	private final ModelRenderer leftleg;
	private final ModelRenderer cube_r10;
	private final ModelRenderer cube_r11;
	private final ModelRenderer cube_r12;
	private final ModelRenderer cube_r13;
	private final ModelRenderer cube_r14;
	private final ModelRenderer cube_r15;
	private final ModelRenderer cube_r16;
	private final ModelRenderer cube_r17;
	private final ModelRenderer bodycenter2;
	private final ModelRenderer bodycenter3;
	private final ModelRenderer bodycenter;

	public Modelirongolem() {
		textureWidth = 128;
		textureHeight = 128;

		body = new ModelRenderer(this);
		body.setRotationPoint(13.0F, 24.0F, 0.0F);
		setRotationAngle(body, 0.0F, 3.1416F, 0.0F);

		cube_r1 = new ModelRenderer(this);
		cube_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
		body.addChild(cube_r1);
		setRotationAngle(cube_r1, -0.3491F, 0.0F, 0.0F);
		cube_r1.setTextureOffset(88, 44).addBox(16.0F, -54.208F, -9.3518F, 5.0F, 1.0F, 4.0F, 0.0F, false);
		cube_r1.setTextureOffset(96, 92).addBox(5.0F, -54.208F, -9.3518F, 5.0F, 1.0F, 4.0F, 0.0F, false);

		rightleg = new ModelRenderer(this);
		rightleg.setRotationPoint(-0.82F, -40.46F, -3.74F);
		body.addChild(rightleg);
		rightleg.setTextureOffset(69, 86).addBox(-0.18F, 39.46F, -7.26F, 1.0F, 1.0F, 12.0F, 0.0F, false);
		rightleg.setTextureOffset(78, 31).addBox(-1.18F, 38.46F, -7.26F, 3.0F, 1.0F, 12.0F, 0.0F, false);
		rightleg.setTextureOffset(73, 73).addBox(-1.18F, 39.46F, -3.26F, 3.0F, 1.0F, 12.0F, 0.0F, false);
		rightleg.setTextureOffset(80, 0).addBox(0.82F, 39.46F, -7.26F, 1.0F, 1.0F, 12.0F, 0.0F, false);
		rightleg.setTextureOffset(16, 93).addBox(1.82F, 39.46F, -6.26F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		rightleg.setTextureOffset(57, 8).addBox(2.82F, 39.46F, -5.26F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		rightleg.setTextureOffset(94, 0).addBox(3.82F, 39.46F, -5.26F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 85).addBox(-1.18F, 39.46F, -7.26F, 1.0F, 1.0F, 12.0F, 0.0F, false);
		rightleg.setTextureOffset(43, 92).addBox(-2.18F, 39.46F, -6.26F, 1.0F, 1.0F, 10.0F, 0.0F, false);
		rightleg.setTextureOffset(28, 93).addBox(-3.18F, 39.46F, -5.26F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		rightleg.setTextureOffset(51, 44).addBox(-4.18F, 39.46F, -4.26F, 1.0F, 1.0F, 6.0F, 0.0F, false);
		rightleg.setTextureOffset(100, 100).addBox(-1.18F, 20.46F, -10.26F, 1.0F, 14.0F, 3.0F, 0.0F, false);
		rightleg.setTextureOffset(80, 99).addBox(0.82F, 20.46F, -10.26F, 1.0F, 14.0F, 3.0F, 0.0F, false);
		rightleg.setTextureOffset(11, 4).addBox(-0.18F, 20.46F, -9.26F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		rightleg.setTextureOffset(12, 23).addBox(-0.18F, 6.46F, -7.26F, 1.0F, 14.0F, 1.0F, 0.0F, false);
		rightleg.setTextureOffset(0, 23).addBox(-1.18F, 6.46F, -10.26F, 3.0F, 14.0F, 3.0F, 0.0F, false);

		cube_r2 = new ModelRenderer(this);
		cube_r2.setRotationPoint(-2.18F, 7.46F, -9.26F);
		rightleg.addChild(cube_r2);
		setRotationAngle(cube_r2, -0.8727F, 0.0F, 0.0F);
		cube_r2.setTextureOffset(0, 10).addBox(0.0F, -4.0F, -2.0F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r2.setTextureOffset(0, 98).addBox(1.0F, -11.0F, -2.0F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r3 = new ModelRenderer(this);
		cube_r3.setRotationPoint(0.82F, 39.46F, -4.26F);
		rightleg.addChild(cube_r3);
		setRotationAngle(cube_r3, 0.6109F, 0.0F, 0.0F);
		cube_r3.setTextureOffset(55, 60).addBox(-1.0F, -8.0F, -2.0F, 1.0F, 8.0F, 3.0F, 0.0F, false);

		cube_r4 = new ModelRenderer(this);
		cube_r4.setRotationPoint(-4.18F, 40.46F, 0.74F);
		rightleg.addChild(cube_r4);
		setRotationAngle(cube_r4, 0.0F, -1.5708F, 0.0F);
		cube_r4.setTextureOffset(57, 18).addBox(-5.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r5 = new ModelRenderer(this);
		cube_r5.setRotationPoint(-3.18F, 40.46F, -4.26F);
		rightleg.addChild(cube_r5);
		setRotationAngle(cube_r5, 0.0F, -2.3562F, 0.0F);
		cube_r5.setTextureOffset(0, 40).addBox(-5.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r6 = new ModelRenderer(this);
		cube_r6.setRotationPoint(4.82F, 40.46F, -5.26F);
		rightleg.addChild(cube_r6);
		setRotationAngle(cube_r6, 0.0F, -0.6109F, 0.0F);
		cube_r6.setTextureOffset(55, 40).addBox(-5.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r7 = new ModelRenderer(this);
		cube_r7.setRotationPoint(5.82F, 40.46F, 0.74F);
		rightleg.addChild(cube_r7);
		setRotationAngle(cube_r7, 0.0F, -1.5708F, 0.0F);
		cube_r7.setTextureOffset(59, 47).addBox(-5.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r8 = new ModelRenderer(this);
		cube_r8.setRotationPoint(4.82F, 40.46F, 1.74F);
		rightleg.addChild(cube_r8);
		setRotationAngle(cube_r8, 0.0F, 0.6109F, 0.0F);
		cube_r8.setTextureOffset(65, 49).addBox(-5.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r9 = new ModelRenderer(this);
		cube_r9.setRotationPoint(-0.18F, 40.46F, 3.74F);
		rightleg.addChild(cube_r9);
		setRotationAngle(cube_r9, 0.0F, -0.6109F, 0.0F);
		cube_r9.setTextureOffset(73, 47).addBox(-5.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		leftleg = new ModelRenderer(this);
		leftleg.setRotationPoint(25.2609F, -40.0435F, -4.3913F);
		body.addChild(leftleg);
		leftleg.setTextureOffset(91, 72).addBox(0.7391F, 39.0435F, -5.6087F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		leftleg.setTextureOffset(53, 80).addBox(-1.2609F, 38.0435F, -5.6087F, 3.0F, 1.0F, 11.0F, 0.0F, false);
		leftleg.setTextureOffset(38, 60).addBox(-1.2609F, 39.0435F, -1.6087F, 3.0F, 1.0F, 11.0F, 0.0F, false);
		leftleg.setTextureOffset(83, 86).addBox(-0.2609F, 39.0435F, -5.6087F, 1.0F, 1.0F, 11.0F, 0.0F, false);
		leftleg.setTextureOffset(96, 31).addBox(2.7391F, 39.0435F, -3.6087F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		leftleg.setTextureOffset(95, 22).addBox(1.7391F, 39.0435F, -4.6087F, 1.0F, 1.0F, 8.0F, 0.0F, false);
		leftleg.setTextureOffset(55, 92).addBox(-1.2609F, 39.0435F, -4.6087F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		leftleg.setTextureOffset(38, 72).addBox(-2.2609F, 39.0435F, -4.6087F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		leftleg.setTextureOffset(98, 13).addBox(-3.2609F, 39.0435F, -3.6087F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		leftleg.setTextureOffset(72, 99).addBox(-1.2609F, 20.0435F, -8.6087F, 1.0F, 14.0F, 3.0F, 0.0F, false);
		leftleg.setTextureOffset(92, 98).addBox(0.7391F, 20.0435F, -8.6087F, 1.0F, 14.0F, 3.0F, 0.0F, false);
		leftleg.setTextureOffset(11, 11).addBox(-0.2609F, 20.0435F, -7.6087F, 1.0F, 3.0F, 1.0F, 0.0F, false);
		leftleg.setTextureOffset(55, 23).addBox(-0.2609F, 6.0435F, -5.6087F, 1.0F, 14.0F, 1.0F, 0.0F, false);
		leftleg.setTextureOffset(0, 60).addBox(-1.2609F, 6.0435F, -8.6087F, 3.0F, 14.0F, 3.0F, 0.0F, false);

		cube_r10 = new ModelRenderer(this);
		cube_r10.setRotationPoint(3.7391F, 6.0435F, -6.6087F);
		leftleg.addChild(cube_r10);
		setRotationAngle(cube_r10, -0.8727F, 0.0F, 0.0F);
		cube_r10.setTextureOffset(0, 0).addBox(-2.0F, -2.0F, -2.0F, 1.0F, 4.0F, 3.0F, 0.0F, false);
		cube_r10.setTextureOffset(0, 44).addBox(-5.0F, -9.0F, -2.0F, 3.0F, 11.0F, 3.0F, 0.0F, false);

		cube_r11 = new ModelRenderer(this);
		cube_r11.setRotationPoint(0.7391F, 38.0435F, 0.3913F);
		leftleg.addChild(cube_r11);
		setRotationAngle(cube_r11, 0.6109F, 0.0F, 0.0F);
		cube_r11.setTextureOffset(78, 31).addBox(-1.0F, -9.0F, -5.0F, 1.0F, 9.0F, 3.0F, 0.0F, false);

		cube_r12 = new ModelRenderer(this);
		cube_r12.setRotationPoint(9.7391F, 40.0435F, 2.3913F);
		leftleg.addChild(cube_r12);
		setRotationAngle(cube_r12, 0.0F, 2.4435F, 0.0F);
		cube_r12.setTextureOffset(19, 72).addBox(7.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r13 = new ModelRenderer(this);
		cube_r13.setRotationPoint(6.7391F, 40.0435F, -9.6087F);
		leftleg.addChild(cube_r13);
		setRotationAngle(cube_r13, 0.0F, -2.5307F, 0.0F);
		cube_r13.setTextureOffset(57, 0).addBox(7.0F, -1.0F, -6.0F, 6.0F, 1.0F, 7.0F, 0.0F, false);

		cube_r14 = new ModelRenderer(this);
		cube_r14.setRotationPoint(4.7391F, 40.0435F, -9.6087F);
		leftleg.addChild(cube_r14);
		setRotationAngle(cube_r14, 0.0F, -1.5708F, 0.0F);
		cube_r14.setTextureOffset(19, 70).addBox(7.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r15 = new ModelRenderer(this);
		cube_r15.setRotationPoint(-3.2609F, 40.0435F, -9.6087F);
		leftleg.addChild(cube_r15);
		setRotationAngle(cube_r15, 0.0F, -1.5708F, 0.0F);
		cube_r15.setTextureOffset(19, 74).addBox(7.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		cube_r16 = new ModelRenderer(this);
		cube_r16.setRotationPoint(-6.2609F, 40.0435F, 10.3913F);
		leftleg.addChild(cube_r16);
		setRotationAngle(cube_r16, 0.0F, 0.6109F, 0.0F);
		cube_r16.setTextureOffset(80, 13).addBox(8.0F, -1.0F, -7.0F, 5.0F, 1.0F, 8.0F, 0.0F, false);

		cube_r17 = new ModelRenderer(this);
		cube_r17.setRotationPoint(-9.2609F, 40.0435F, -1.6087F);
		leftleg.addChild(cube_r17);
		setRotationAngle(cube_r17, 0.0F, -0.6109F, 0.0F);
		cube_r17.setTextureOffset(76, 0).addBox(7.0F, -1.0F, 0.0F, 6.0F, 1.0F, 1.0F, 0.0F, false);

		bodycenter2 = new ModelRenderer(this);
		bodycenter2.setRotationPoint(13.0F, -39.0F, -4.0F);
		body.addChild(bodycenter2);
		bodycenter2.setTextureOffset(0, 0).addBox(-9.0F, -2.0F, -5.0F, 18.0F, 2.0F, 21.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 60).addBox(-9.0F, -10.0F, -2.0F, 1.0F, 8.0F, 17.0F, 0.0F, false);
		bodycenter2.setTextureOffset(49, 55).addBox(8.0F, -10.0F, -2.0F, 1.0F, 8.0F, 17.0F, 0.0F, false);
		bodycenter2.setTextureOffset(21, 70).addBox(-9.0F, -18.0F, -2.0F, 1.0F, 8.0F, 15.0F, 0.0F, false);
		bodycenter2.setTextureOffset(63, 8).addBox(8.0F, -18.0F, -2.0F, 1.0F, 8.0F, 15.0F, 0.0F, false);
		bodycenter2.setTextureOffset(68, 55).addBox(-8.0F, -18.0F, -2.0F, 17.0F, 16.0F, 1.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 44).addBox(-9.0F, -19.0F, -2.0F, 18.0F, 1.0F, 15.0F, 0.0F, false);
		bodycenter2.setTextureOffset(11, 0).addBox(9.0F, -12.0F, 1.0F, 2.0F, 2.0F, 2.0F, 0.0F, false);
		bodycenter2.setTextureOffset(51, 55).addBox(-13.0F, -12.0F, 1.0F, 4.0F, 2.0F, 2.0F, 0.0F, false);
		bodycenter2.setTextureOffset(11, 11).addBox(-14.0F, -13.0F, 0.0F, 1.0F, 4.0F, 4.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 10).addBox(-13.0F, -10.0F, 1.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		bodycenter2.setTextureOffset(0, 0).addBox(-13.0F, -13.0F, 1.0F, 1.0F, 1.0F, 9.0F, 0.0F, false);
		bodycenter2.setTextureOffset(96, 84).addBox(-15.0F, -13.0F, 1.0F, 1.0F, 1.0F, 7.0F, 0.0F, false);
		bodycenter2.setTextureOffset(19, 60).addBox(-3.0F, 0.0F, 8.0F, 6.0F, 3.0F, 7.0F, 0.0F, false);
		bodycenter2.setTextureOffset(60, 31).addBox(-1.0F, 1.0F, 4.0F, 2.0F, 2.0F, 14.0F, 0.0F, false);
		bodycenter2.setTextureOffset(55, 31).addBox(11.0F, -12.0F, 1.0F, 2.0F, 2.0F, 7.0F, 0.0F, false);

		bodycenter3 = new ModelRenderer(this);
		bodycenter3.setRotationPoint(13.0F, -54.0F, 8.0F);
		body.addChild(bodycenter3);
		setRotationAngle(bodycenter3, -1.3963F, 0.0F, 0.0F);
		bodycenter3.setTextureOffset(0, 23).addBox(-9.0F, -2.0F, -3.0F, 18.0F, 2.0F, 19.0F, 0.0F, false);

		bodycenter = new ModelRenderer(this);
		bodycenter.setRotationPoint(13.0F, -39.0F, -6.0F);
		body.addChild(bodycenter);
		bodycenter.setTextureOffset(51, 51).addBox(-15.0F, -2.0F, 1.0F, 30.0F, 2.0F, 2.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.leftleg.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.rightleg.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
	}
}