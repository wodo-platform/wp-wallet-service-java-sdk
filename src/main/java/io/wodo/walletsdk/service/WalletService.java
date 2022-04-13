package io.wodo.walletsdk.service;

import io.wodo.walletsdk.domain.Wallet;
import io.wodo.walletsdk.enumtype.EnumStatus;
import io.wodo.walletsdk.exception.WalletNotFoundException;
import io.wodo.walletsdk.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public Wallet createWallet(Wallet wallet) {
        return walletRepository.save(wallet);
    }

    public List<Wallet> getAllWallets() {
        return walletRepository.findAll();
    }

    public Wallet findById(Long walletId) {
        Optional<Wallet> _wallet = walletRepository.findById(walletId);
        if (_wallet.isPresent() && _wallet.get().getStatus() == EnumStatus.ACTIVE) {
            return _wallet.get();
        } else {
            throw new WalletNotFoundException();
        }
    }

    public Wallet updateWallet(Long walletId, Wallet wallet) {
        Wallet _wallet = findById(walletId);
        _wallet.setStatus(wallet.getStatus());
        _wallet.setAmount(wallet.getAmount());
        return walletRepository.save(_wallet);
    }

    public Wallet deleteWallet(Long walletId) {
        Wallet _wallet = findById(walletId);
        _wallet.setStatus(EnumStatus.DELETED);
        return walletRepository.save(_wallet);
    }
}