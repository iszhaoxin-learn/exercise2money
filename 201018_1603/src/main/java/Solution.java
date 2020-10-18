class ParkingSystem {
    public int[] nums;
    public ParkingSystem(int big, int medium, int small) {
        nums = new int[3]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if(nums[carType-1]>0){
            nums[carType-1] -= 1;
            return true;
        }
        else return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */